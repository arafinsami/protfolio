package com.hcl.protfolio.service;


import com.hcl.protfolio.dto.PortfolioDTO;
import com.hcl.protfolio.entity.Portfolio;
import com.hcl.protfolio.mapper.PortfolioMapper;
import com.hcl.protfolio.repository.PortfolioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PortfolioService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PortfolioService.class);

    private final PortfolioRepository accountRepository;

    private final PortfolioMapper portfolioMapper;

    private final AuditDataService auditDataService;

    @Transactional
    public Portfolio save(PortfolioDTO request) {
        Portfolio portfolio = portfolioMapper.save(request);
        accountRepository.save(portfolio);
        auditDataService.publishActivity(
                //save audit data
        );
        return portfolio;
    }

}
