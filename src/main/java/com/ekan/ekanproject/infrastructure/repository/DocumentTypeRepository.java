package com.ekan.ekanproject.infrastructure.repository;

import com.ekan.ekanproject.domain.model.DocumentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentTypeRepository extends JpaRepository<DocumentType, Long> {
}
