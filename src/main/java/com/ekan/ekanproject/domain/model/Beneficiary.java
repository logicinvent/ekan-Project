package com.ekan.ekanproject.domain.model;

import java.time.LocalDate;
import java.util.List;

public class Beneficiary {

    private Long id;
    private String name;
    private String phone;
    private LocalDate birthDay;
    private List<Document> documents;
    private LocalDate eventDate;
    private LocalDate updateDate;


}
