package com.hcl.protfolio.repository;

import com.hcl.protfolio.entity.Audit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditRepository extends JpaRepository<Audit, String> {
}
