package com.ekan.ekanproject.domain.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BeneficiaryNotFoundException extends RuntimeException {
    public BeneficiaryNotFoundException(String message) {
        super(message);
        log.error(message);
    }
}

