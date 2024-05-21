package com.ekan.ekanproject.infrastructure.repository;

import com.ekan.ekanproject.domain.model.Beneficiary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeneficiaryRepository extends JpaRepository<Beneficiary, Long> {

}
