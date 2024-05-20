package com.ekan.ekanproject.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "DOCUMENT-TYPE")
public class DocumentType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "description")
    private String description;

    public DocumentType setId(Long id) {
        this.id = id;
        return this;
    }

    public DocumentType setDescription(String description) {
        this.description = description;
        return this;
    }
}
