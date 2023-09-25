package com.task.dms.business.dto;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ErrorResponse {
    private int code;
    private Boolean status;
    private String message;
    private HttpStatus httpstatus;
}
