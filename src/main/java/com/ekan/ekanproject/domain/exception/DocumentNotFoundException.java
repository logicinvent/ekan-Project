package com.ekan.ekanproject.domain.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DocumentNotFoundException extends RuntimeException {
    public DocumentNotFoundException(String message) {
        super(message);
        log.error(message);
    }
}

