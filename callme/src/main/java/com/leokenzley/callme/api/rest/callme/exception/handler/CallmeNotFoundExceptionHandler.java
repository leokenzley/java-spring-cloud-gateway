package com.leokenzley.callme.api.rest.callme.exception.handler;

import com.leokenzley.callme.api.exception.APIErrors;
import com.leokenzley.callme.api.rest.callme.exception.NotFoundExeception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ControllerAdvice
public class CallmeNotFoundExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    @ExceptionHandler(NotFoundExeception.class)
    protected APIErrors handleNotFound(
            NotFoundExeception ex) {
        APIErrors apiErrors = new APIErrors();
        apiErrors.setMessage(ex.getMessage());
        apiErrors.setTimestamp(LocalDateTime.now());
        apiErrors.setStatusCode(404);
        return apiErrors;
    }
}
