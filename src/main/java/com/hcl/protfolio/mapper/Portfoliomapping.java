package com.hcl.protfolio.mapper;

import com.hcl.protfolio.dto.PortfolioDTO;
import com.hcl.protfolio.entity.Portfolio;
import org.mapstruct.factory.Mappers;

public interface Portfoliomapping {

    Portfoliomapping INSTANCE = Mappers.getMapper(Portfoliomapping.class);

    Portfolio save(PortfolioDTO dto);

    PortfolioDTO from(Portfolio portfolio);
}
