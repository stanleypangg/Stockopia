package com.stanleypangg.stockopia.global.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class ErrorResponse {

    private int statusCode;
    private String message;
    private String requestUri;
    private LocalDateTime timestamp;
    private String exception;

    public ErrorResponse(int statusCode, String message, String requestUri, String exception) {
        this.statusCode = statusCode;
        this.message = message;
        this.requestUri = requestUri;
        this.timestamp = LocalDateTime.now();
        this.exception = exception;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRequestUri() {
        return requestUri;
    }

    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }
}
