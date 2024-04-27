package com.hcl.protfolio.kafka;

import com.hcl.protfolio.message.AuditMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@EnableKafka
@RequiredArgsConstructor
public class AuditProducer {

    private final KafkaTemplate<String, AuditMessage> kafkaTemplate;

    public void sendAuditMessage(AuditMessage auditMessage) {
        kafkaTemplate.send("portfolio_management", auditMessage);
    }
}
