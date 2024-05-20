package com.ekan.ekanproject.domain.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

import java.io.Serializable;

@Embeddable
@Getter
public class DocumentId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "document_type_id", insertable = false, updatable = false, nullable = false)
    private DocumentType documentType;

    @ManyToOne
    @JoinColumn(name = "beneficiary_id", nullable = false, insertable = false, updatable = false)
    private Beneficiary beneficiary;

    public DocumentId setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
        return this;
    }

    public DocumentId setBeneficiary(Beneficiary beneficiary) {
        this.beneficiary = beneficiary;
        return this;
    }
}
