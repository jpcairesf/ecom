package com.ecom.product.config;

import com.ecom.product.config.response.APIErrorResponse;
import com.ecom.product.exception.BusinessException;
import com.ecom.product.exception.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;
import java.util.NoSuchElementException;

@RestControllerAdvice
@Slf4j
public class ControllerAdvice {

    @ExceptionHandler({
        EntityNotFoundException.class,
        NoSuchElementException.class,
        EmptyResultDataAccessException.class
    })
    public ResponseEntity<APIErrorResponse> handleNotFound(Exception ex, WebRequest req) {
        return this.handleError(HttpStatus.NOT_FOUND, ex, req);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<APIErrorResponse> handleBusinessError(Exception ex, WebRequest req) {
        return this.handleError(HttpStatus.BAD_REQUEST, ex, req);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<APIErrorResponse> handleRuntimeException(Exception ex, WebRequest req) {
        return this.handleError(HttpStatus.INTERNAL_SERVER_ERROR, ex, req);
    }

    private ResponseEntity<APIErrorResponse> handleError(HttpStatus status, Exception ex, WebRequest request) {
        log.error("API Error", ex);
        return this.getResponse(status, ex, request);
    }

    private ResponseEntity<APIErrorResponse> getResponse(HttpStatus status, Exception ex, WebRequest request) {
        APIErrorResponse message = new APIErrorResponse(
                ex.getMessage(),
                status.value(),
                status.getReasonPhrase(),
                LocalDate.now(),
                request.getDescription(false));
        return ResponseEntity.status(status).body(message);
    }

}
