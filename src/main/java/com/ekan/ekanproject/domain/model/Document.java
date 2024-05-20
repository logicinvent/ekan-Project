package com.ekan.ekanproject.domain.model;

import com.ekan.ekanproject.infrastructure.annotation.EventDateAt;
import com.ekan.ekanproject.infrastructure.annotation.UpdatedAt;
import com.ekan.ekanproject.infrastructure.annotation.listenner.EventDateAtListener;
import com.ekan.ekanproject.infrastructure.annotation.listenner.UpdatedDateAtListener;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "DOCUMENT")
@EntityListeners({UpdatedDateAtListener.class, EventDateAtListener.class})
public class Document {

    @EmbeddedId
    private DocumentId id;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("beneficiaryId")
    @JoinColumn(name = "beneficiary_id", insertable = false, updatable = false)
    private Beneficiary beneficiary;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("documentTypeId")
    @JoinColumn(name = "document_type_id", insertable = false, updatable = false)
    private DocumentType documentType;

    @Column(name = "description")
    private String description;

    @EventDateAt
    @Column(name = "eventDate")
    private LocalDateTime eventDate;

    @UpdatedAt
    @Column(name = "updateDate")
    private LocalDateTime updateDate;

}
