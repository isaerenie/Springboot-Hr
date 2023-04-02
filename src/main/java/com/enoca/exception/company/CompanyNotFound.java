package com.enoca.exception.company;

import com.enoca.util.ResponseStatus;
import lombok.Getter;

import static com.enoca.util.ResponseStatus.FAILURE;
@Getter
public class CompanyNotFound extends RuntimeException {
    private final String message="Böyle bir şirket bulunamadı.";
    private final ResponseStatus status= FAILURE;
    private final String code="0x000";
}
