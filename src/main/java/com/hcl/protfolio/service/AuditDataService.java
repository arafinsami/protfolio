package com.hcl.protfolio.service;



import com.hcl.protfolio.controller.AuditController;
import com.hcl.protfolio.entity.Audit;
import com.hcl.protfolio.repository.AuditRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AuditDataService {
	
	private static final Logger logger = LoggerFactory.getLogger(AuditDataService.class);

	@Autowired
    private AuditRepository auditRepository;

	/*
	 * @Transactional public void publishActivity() { Audit auditData = new Audit();
	 * auditData.setAuditDate(new Date()); auditRepository.save(auditData); }
	 */

	public List<Audit> findAll() {
		logger.info("-----getAuditList-----");
		return auditRepository.findAll();
	}

	public Audit findByCustomerId(String Id) {
		// TODO Auto-generated method stub
		return auditRepository.findByCustomerId(Id);
	}
}
