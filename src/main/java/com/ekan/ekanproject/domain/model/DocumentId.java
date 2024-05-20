package com.ekan.ekanproject.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.io.Serializable;

@Embeddable
@Getter
public class DocumentId implements Serializable {

    @Column(name = "beneficiary_id")
    private Long beneficiaryId;

    @Column(name = "document_type_id")
    private Long documentTypeId;

    public DocumentId setDocumentType(Long documentType) {
        this.documentTypeId = documentType;
        return this;
    }

    public DocumentId setBeneficiary(Long beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
        return this;
    }
}
