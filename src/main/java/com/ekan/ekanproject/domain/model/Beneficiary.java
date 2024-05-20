package com.ekan.ekanproject.domain.model;

import com.ekan.ekanproject.infrastructure.annotation.EventDateAt;
import com.ekan.ekanproject.infrastructure.annotation.UpdatedAt;
import com.ekan.ekanproject.infrastructure.annotation.listenner.EventDateAtListener;
import com.ekan.ekanproject.infrastructure.annotation.listenner.UpdatedDateAtListener;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "BENEFICIARY")
@EntityListeners({UpdatedDateAtListener.class, EventDateAtListener.class})
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

    @EventDateAt
    @Column(name = "eventDate")
    private LocalDateTime eventDate;

    @UpdatedAt
    @Column(name = "updateDate")
    private LocalDateTime updateDate;

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

    public Beneficiary setEventDate(LocalDateTime eventDate) {
        this.eventDate = eventDate;
        return this;
    }

    public Beneficiary setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
        return this;
    }
}
