package com.getyourguide.mycompany.exception;

import java.util.Map;
import lombok.Getter;

@Getter
public class MyCompanyException extends RuntimeException {
    private final Integer errorCode;
    private final String errorMessage;
    private final Map<String, Object> errorDetails;


    public MyCompanyException(Integer errorCode, String errorMessage,
                              Map<String, Object> errorDetails) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.errorDetails = errorDetails;
    }
}
