package com.getyourguide.mycompany.exception;

import org.springframework.http.HttpStatus;

public class MyCompanyBusinessException extends MyCompanyException {

    public MyCompanyBusinessException(HttpStatus httpStatusCode, Integer errorCode,
                                      String errorMessage) {
        super(httpStatusCode, errorCode, errorMessage);
    }
}
