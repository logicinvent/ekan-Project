package com.ekan.ekanproject.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "DOCUMENT")
public class Document {

    @EmbeddedId
    private DocumentId id;

    @Column(name = "description")
    private String description;

    @Column(name = "eventdate")
    private LocalDate eventDate;

    @Column(name = "updatedate")
    private LocalDate updateDate;

}
