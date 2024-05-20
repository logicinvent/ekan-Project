package com.ekan.ekanproject.infrastructure.repository;

import com.ekan.ekanproject.domain.model.Document;
import com.ekan.ekanproject.domain.model.DocumentId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, DocumentId> {
}
