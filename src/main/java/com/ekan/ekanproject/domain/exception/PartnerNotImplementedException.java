package com.ekan.ekanproject.domain.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PartnerNotImplementedException extends RuntimeException {
    public PartnerNotImplementedException(String message) {
        super(message);
        log.error(message);
    }
}

