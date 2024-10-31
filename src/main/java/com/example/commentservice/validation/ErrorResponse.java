package com.example.commentservice.validation;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private String errorMessage;
    private LocalDateTime errorDateTime;
}
