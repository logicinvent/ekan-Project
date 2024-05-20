package com.ekan.ekanproject.domain.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@Slf4j
@ControllerAdvice
public class ExceptionHandlerFilter extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BeneficiaryNotFoundException.class)
    public ResponseEntity<Object> handleBeneficiaryNotFoundException(
            Exception ex, WebRequest request) {

        log.error(String.valueOf(ex));
        return new ResponseEntity<Object>(
                ErrorResponse.<BeneficiaryNotFoundException>builder()
                        .locale(request.getLocale())
                        .message("Beneficiary not found")
                        .exceptionMessage(ex.getMessage())
                        .exceptionClass(BeneficiaryNotFoundException.class)
                        .code(HttpStatus.NOT_FOUND.value())
                        .timestamp(LocalDateTime.now())
                        .exception(ex)
                        .build(), new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DocumentNotFoundException.class)
    public ResponseEntity<Object> handleDocumentNotFoundException(
            Exception ex, WebRequest request) {
        log.error(String.valueOf(ex));
        return new ResponseEntity<Object>(
                ErrorResponse.<DocumentNotFoundException>builder()
                        .locale(request.getLocale())
                        .message("Document not found")
                        .exceptionMessage(ex.getMessage())
                        .exceptionClass(DocumentNotFoundException.class)
                        .code(HttpStatus.NOT_FOUND.value())
                        .timestamp(LocalDateTime.now())
                        .exception(ex)
                        .build(), new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DocumentTypeNotFoundException.class)
    public ResponseEntity<Object> handleDocumentTypeNotFoundException(
            Exception ex, WebRequest request) {
        log.error(String.valueOf(ex));
        return new ResponseEntity<Object>(
                ErrorResponse.<DocumentTypeNotFoundException>builder()
                        .locale(request.getLocale())
                        .message("Document type not found")
                        .exceptionMessage(ex.getMessage())
                        .exceptionClass(DocumentTypeNotFoundException.class)
                        .code(HttpStatus.NOT_FOUND.value())
                        .timestamp(LocalDateTime.now())
                        .exception(ex)
                        .build(), new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<Object> handleIllegalStateException(
            Exception ex, WebRequest request) {
        log.error(String.valueOf(ex));
        return new ResponseEntity<Object>(
                ErrorResponse.<IllegalStateException>builder()
                        .locale(request.getLocale())
                        .message("Signals that a method has been invoked at an illegal or inappropriate time. In other words, the Java environment or Java application is not in an appropriate state for the requested operation.")
                        .exceptionMessage(ex.getMessage())
                        .exceptionClass(IllegalStateException.class)
                        .code(HttpStatus.BAD_REQUEST.value())
                        .timestamp(LocalDateTime.now())
                        .exception(ex)
                        .build(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleCustomException(
            Exception ex, WebRequest request) {
        log.error(String.valueOf(ex));
        return new ResponseEntity<Object>(
                ErrorResponse.<Exception>builder()
                        .locale(request.getLocale())
                        .message("The class Exception and its subclasses are a form of Throwable that indicates conditions that a reasonable application might want to catch.\n" +
                                "The class Exception and any subclasses that are not also subclasses of RuntimeException are checked exceptions. Checked exceptions need to be declared in a method or constructor's throws clause if they can be thrown by the execution of the method or constructor and propagate outside the method or constructor boundary.")
                        .exceptionMessage(ex.getMessage())
                        .exceptionClass(Exception.class)
                        .code(HttpStatus.BAD_REQUEST.value())
                        .timestamp(LocalDateTime.now())
                        .exception(ex)
                        .build(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

}
