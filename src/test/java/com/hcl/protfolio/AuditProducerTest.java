package com.hcl.protfolio;

import com.hcl.protfolio.entity.TradeType;
import com.hcl.protfolio.kafka.AuditProducer;
import com.hcl.protfolio.message.AuditMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.Date;

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class AuditProducerTest {

    @Mock
    private KafkaTemplate<String, AuditMessage> kafkaTemplate;

    @InjectMocks
    private AuditProducer auditProducer;

    @Test
    public void testSendAuditMessage() {
        AuditMessage auditMessage = new AuditMessage();
        auditMessage.setTransactionRef("jdhd");
        auditMessage.setInstrumentId("jdhd");
        auditMessage.setInstrumentName("jdhd");
        auditMessage.setTradeType(TradeType.BUY);
        auditMessage.setAuditDate(new Date());
        auditMessage.setCustomerId("ndsf");
        auditProducer.sendAuditMessage(auditMessage);
        verify(kafkaTemplate, times(1)).send(eq("portfolio_management"), eq(auditMessage));
    }
}