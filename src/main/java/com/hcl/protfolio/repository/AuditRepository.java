package com.hcl.protfolio.repository;

import com.hcl.protfolio.entity.Audit;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AuditRepository extends JpaRepository<Audit, String> {
	
	@Query("SELECT a FROM Audit a WHERE a.cutomerId = :cutomerId")
	Audit findByCustomerId(@Param("cutomerId") String cutomerId);
}
