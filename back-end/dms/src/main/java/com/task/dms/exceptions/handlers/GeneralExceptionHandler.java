package com.task.dms.exceptions.handlers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.task.dms.business.dto.ErrorResponse;
import com.task.dms.exceptions.DuplicatedExceptions;
import com.task.dms.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleTypeMismatch(ResourceNotFoundException ex, HttpServletRequest req) {
        String message = String.format("resource with id:%s is not found", ex.getId());

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(message);
        errorResponse.setStatus(true);
        errorResponse.setCode(400);
        errorResponse.setHttpstatus(HttpStatus.valueOf(400));

        return new ResponseEntity<>(errorResponse,errorResponse.getHttpstatus());
    }

    @ExceptionHandler(DuplicatedExceptions.class)
    public ResponseEntity<ErrorResponse> handleDuplicated(DuplicatedExceptions ex, HttpServletRequest req) {
        String message = String.format("resource with id:%s is Duplicated", ex.getId());

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(message);
        errorResponse.setStatus(true);
        errorResponse.setCode(400);
        errorResponse.setHttpstatus(HttpStatus.valueOf(400));

        return new ResponseEntity<>(errorResponse,errorResponse.getHttpstatus());
    }
}
