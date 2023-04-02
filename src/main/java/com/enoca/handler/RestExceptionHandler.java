package com.enoca.handler;

import com.enoca.exception.company.CompanyNotFound;
import com.enoca.exception.personel.EmployeeNotFound;
import com.enoca.util.ResponseMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(CompanyNotFound.class)
    public ResponseMap companyNotFound(CompanyNotFound e) {
        return ResponseMap.builder()
                .message(e.getMessage())
                .code(e.getCode())
                .status(e.getStatus())
                .build();

    }
    @ExceptionHandler(EmployeeNotFound.class)
    public ResponseMap employeeNotFound(EmployeeNotFound e) {
        return ResponseMap.builder()
                .message(e.getMessage())
                .code(e.getCode())
                .status(e.getStatus())
                .build();

    }
}
