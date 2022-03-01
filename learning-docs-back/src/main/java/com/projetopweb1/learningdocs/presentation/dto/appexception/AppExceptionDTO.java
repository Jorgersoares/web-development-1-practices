package com.projetopweb1.learningdocs.presentation.dto.appexception;

import org.springframework.http.HttpStatus;

public class AppExceptionDTO {
    private int status;
    private String statusMessage;
    private String message;

    public AppExceptionDTO(int status, String statusMessage, String message) {
        this.status = status;
        this.statusMessage = statusMessage;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
