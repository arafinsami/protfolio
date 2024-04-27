package com.hcl.protfolio.test.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;

import org.assertj.core.util.Arrays;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.hcl.protfolio.controller.AuditController;
import com.hcl.protfolio.entity.Audit;
import com.hcl.protfolio.entity.TradeType;
import com.hcl.protfolio.repository.AuditRepository;
import com.hcl.protfolio.service.AuditDataService;


import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;


//@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
public class AuditControllerTest {
	
	private MockMvc mockMvc;
	
	ObjectMapper objectMapper=new ObjectMapper();
	ObjectWriter objectwriter=objectMapper.writer();
	
	@Mock
	private AuditDataService auditDataService;
	 
	@Mock
	private AuditRepository auditRepository;

	@InjectMocks
	//@Mock
	private AuditController auditController;
	
	String input1 = "2024-04-27";
    LocalDate date1 = LocalDate.parse(input1);
	/*
	 * DateTimeFormatter formatter = new DateTimeFormatter. ("yyyy-MM-dd HH:mm:ss");
	 * //DateTimeFormatter formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 * DateTimeFormatter formatter2 =
	 * DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"); Date dtIn =
	 * formatter2.parse(input1); Date dateFormatted1 = new SimpleDateTime();
	 */
	
	Audit record1=new Audit("1","abcd","1",1L,"property1","BUY", date1);
	Audit record2=new Audit("2","efgh","2",2L,"property2","BUY", date1);
	
	 Consumer<Integer> method = (n) -> { System.out.println(n); }; 
	 
	@BeforeEach
	public void setUp() {
		//MockitoAnnotations.initMocks(this);
		MockitoAnnotations.openMocks(this); 
		this.mockMvc=MockMvcBuilders.standaloneSetup(auditController).build();
	}
	
	
	  @Test public void getAllRecords_success() throws Exception{ 
		 //setUp();
		  List<Audit> records=new ArrayList<>(); 
		  records.add(record1);
		  records.add(record2); 
		 
		  Mockito.when(auditDataService.findAll()).thenReturn(records);
		  
		  mockMvc.perform(MockMvcRequestBuilders .get("/audit")
		  .contentType(MediaType.APPLICATION_JSON)) .andExpect(status().isOk())
		  .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));
		  
	  }
	 
		/*
		 * @Test public void getRecordsById_success() throws Exception{  
		 * Audit records=new Audit("1","abcd","1",1L,"property1","BUY", date1);
		 * 
		 * Mockito.when(auditDataService.findByCustomerId("1")).thenReturn(records);
		 * 
		 * mockMvc.perform(MockMvcRequestBuilders .get("/audit/{id}")
		 * .contentType(MediaType.APPLICATION_JSON)) .andExpect(status().isOk())
		 * .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));
		 * 
		 * }
		 */
	
}
