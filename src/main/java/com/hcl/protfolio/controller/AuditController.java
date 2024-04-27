package com.hcl.protfolio.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.protfolio.entity.Audit;
import com.hcl.protfolio.service.AuditDataService;
//import com.hcl.protfolio.entry.Audit;

@RestController
@RequestMapping("/audit")
public class AuditController {
	
	private static final Logger logger = LoggerFactory.getLogger(AuditController.class);

	@Autowired
	private AuditDataService auditDataService;

	//This api is get all audit details
	@GetMapping
    public List<Audit> findAll() {
    	logger.info("**********findAll ********");
        return auditDataService.findAll();
    }
	
	@GetMapping("/{id}")
    public Audit findByCustomerId(@PathVariable String id) {
    	logger.info("**********findById ********");
        return auditDataService.findByCustomerId(id);
    }
}
