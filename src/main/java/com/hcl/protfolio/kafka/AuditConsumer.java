package com.hcl.protfolio.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.protfolio.message.AuditMessage;
import com.hcl.protfolio.service.AuditDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.retrytopic.DltStrategy;
import org.springframework.kafka.retrytopic.TopicSuffixingStrategy;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@EnableKafka
@RequiredArgsConstructor
public class AuditConsumer {

    private final AuditDataService auditDataService;

    @RetryableTopic(
            attempts = "4",
            backoff = @Backoff(delay = 2000, multiplier = 2.0),
            autoCreateTopics = "false",
            topicSuffixingStrategy = TopicSuffixingStrategy.SUFFIX_WITH_INDEX_VALUE,
            dltStrategy = DltStrategy.FAIL_ON_ERROR)
    @KafkaListener(
            topics = "portfolio_management",
            groupId = "Event_HCL_Portfolio_Management"
    )
    public void listen(String string) throws com.fasterxml.jackson.core.JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        AuditMessage message = mapper.readValue(string, AuditMessage.class);
        log.info("Received audit {}", message);
        auditDataService.publishActivity(message);
    }
}
