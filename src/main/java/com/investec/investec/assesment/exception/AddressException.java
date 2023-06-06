package com.investec.investec.assesment.exception;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Data
@Builder
@ResponseStatus(HttpStatus.EXPECTATION_FAILED)
public class AddressException extends Exception {
    private String message;
}
