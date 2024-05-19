package com.ekan.ekanproject.domain.dto.shared.enums;

public enum ProductTypeValues {

    EKAN("EKAN"),
    PARTNERS("PARTNERS");

    private String value;

    ProductTypeValues(String value) {
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}
