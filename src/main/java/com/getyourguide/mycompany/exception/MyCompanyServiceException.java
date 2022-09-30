package com.getyourguide.mycompany.exception;

import java.util.Map;

public class MyCompanyServiceException extends MyCompanyException {
    public MyCompanyServiceException(Integer errorCode, String errorMessage,
                                     Map<String, Object> errorDetails) {
        super(errorCode, errorMessage, errorDetails);
    }
}
