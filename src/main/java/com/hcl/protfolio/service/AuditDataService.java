package com.hcl.protfolio.service;


import com.hcl.protfolio.entity.Audit;
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
    public void publishActivity() {
        Audit auditData = new Audit();
        auditData.setAuditDate(new Date());
        auditRepository.save(auditData);
    }
}
