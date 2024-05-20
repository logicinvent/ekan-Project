package com.ekan.ekanproject.domain.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DocumentTypeNotFoundException extends RuntimeException {
    public DocumentTypeNotFoundException(String message) {
        super(message);
        log.error(message);
    }
}

