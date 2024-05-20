package com.ekan.ekanproject.domain.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Locale;

@Data
@Builder
public class ErrorResponse<T> {

    private Integer code;
    private Locale locale;
    private String message;
    private String exceptionMessage;
    private LocalDateTime timestamp;
    private Exception exception;
    private Class<T> exceptionClass;

}