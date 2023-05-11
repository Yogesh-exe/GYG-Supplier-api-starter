package com.getyourguide.mycompany.exception;

import org.springframework.http.HttpStatus;

public class MyCompanyTechnicalException extends MyCompanyException {

    public MyCompanyTechnicalException(HttpStatus httpStatusCode, Integer errorCode,
                                       String errorMessage) {
        super(httpStatusCode, errorCode, errorMessage);
    }
}
