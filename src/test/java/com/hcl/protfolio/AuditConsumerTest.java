package com.hcl.protfolio;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.protfolio.kafka.AuditConsumer;
import com.hcl.protfolio.message.AuditMessage;
import com.hcl.protfolio.service.AuditDataService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AuditConsumerTest {

    @Mock
    private AuditDataService auditDataService;

    @InjectMocks
    private AuditConsumer auditConsumer;

    @Test
    public void testListen() throws JsonProcessingException {
        String jsonString = "{\"transactionRef\":\"123\",\"instrumentId\":1,\"instrumentName\":\"TestInstrument\",\"tradeType\":\"Buy\",\"auditDate\":\"2024-04-27\"}";
        AuditMessage expectedMessage = new ObjectMapper().readValue(jsonString, AuditMessage.class);
        auditConsumer.listen(jsonString);
        verify(auditDataService, times(1)).publishActivity(expectedMessage);
    }
}
