package com.getyourguide.mycompany.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public class MyCompanyException extends RuntimeException {
    private final HttpStatus httpStatusCode;
    private final Integer errorCode;
    private final String errorMessage;

}
