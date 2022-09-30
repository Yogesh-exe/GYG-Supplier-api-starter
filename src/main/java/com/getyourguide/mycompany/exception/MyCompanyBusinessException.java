package com.getyourguide.mycompany.exception;

import java.util.Map;

public class MyCompanyBusinessException extends MyCompanyException {
    public MyCompanyBusinessException(Integer errorCode, String errorMessage,
                                      Map<String, Object> errorDetails) {
        super(errorCode, errorMessage, errorDetails);
    }
}
