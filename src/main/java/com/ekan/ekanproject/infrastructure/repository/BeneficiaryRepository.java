package com.ekan.ekanproject.infrastructure.repository;

import com.ekan.ekanproject.domain.model.Beneficiary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BeneficiaryRepository extends JpaRepository<Beneficiary, Long> {

    Optional<Beneficiary> findById(Long id);
}
