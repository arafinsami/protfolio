package com.hcl.protfolio.service;


import com.hcl.protfolio.entity.Audit;
import com.hcl.protfolio.message.AuditMessage;
import com.hcl.protfolio.repository.AuditRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class AuditDataService {

    private final AuditRepository auditRepository;

    @Transactional
    public void publishActivity(AuditMessage auditMessage) {
        Audit audit = new Audit();
        audit.setTransactionRef(auditMessage.getTransactionRef());
        audit.setInstrumentId(auditMessage.getInstrumentId());
        audit.setInstrumentName(auditMessage.getInstrumentName());
        audit.setTradeType(auditMessage.getTradeType());
        audit.setAuditDate(auditMessage.getAuditDate());
        audit.setAuditDate(new Date());
        auditRepository.save(audit);
    }
}
