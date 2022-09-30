package com.getyourguide.mycompany.exception;

import java.util.Map;

public class MyCompanyTechnicalException extends MyCompanyException {
    public MyCompanyTechnicalException(Integer errorCode, String errorMessage,
                                       Map<String, Object> errorDetails) {
        super(errorCode, errorMessage, errorDetails);
    }
}
