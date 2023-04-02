package com.enoca.exception.personel;

import com.enoca.util.ResponseStatus;
import lombok.Getter;

import static com.enoca.util.ResponseStatus.FAILURE;
@Getter
public class EmployeeNotFound extends RuntimeException {
    private final String message="Böyle bir çalışan bulunamadı.";
    private final ResponseStatus status= FAILURE;
    private final String code="0x000";
}
