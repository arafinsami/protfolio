package com.hcl.protfolio.repository;

import com.hcl.protfolio.entity.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, String> {
}
