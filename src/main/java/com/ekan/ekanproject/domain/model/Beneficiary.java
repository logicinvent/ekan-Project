package com.ekan.ekanproject.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Entity
@Table(name = "BENEFICIARY")
public class Beneficiary {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "birthday")
    private LocalDate birthDay;

    @Column(name = "eventdate")
    private LocalDate eventDate;

    @Column(name = "updatedate")
    private LocalDate updateDate;

    public Beneficiary setId(Long id) {
        this.id = id;
        return this;
    }

    public Beneficiary setName(String name) {
        this.name = name;
        return this;
    }

    public Beneficiary setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Beneficiary setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
        return this;
    }

    public Beneficiary setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
        return this;
    }

    public Beneficiary setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
        return this;
    }
}
