package com.hcl.protfolio.mapper;

import com.hcl.protfolio.dto.PortfolioDTO;
import com.hcl.protfolio.entity.Portfolio;
import org.springframework.stereotype.Component;

@Component
public class PortfolioMapper {

    public Portfolio save(PortfolioDTO dto) {
        return Portfoliomapping.INSTANCE.save(dto);
    }

    public PortfolioDTO from(Portfolio portfolio) {
        return Portfoliomapping.INSTANCE.from(portfolio);
    }
}
