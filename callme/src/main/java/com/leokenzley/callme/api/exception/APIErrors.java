package com.leokenzley.callme.api.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class APIErrors {
    private LocalDateTime timestamp;
    private String message;
    private Integer statusCode;
}
