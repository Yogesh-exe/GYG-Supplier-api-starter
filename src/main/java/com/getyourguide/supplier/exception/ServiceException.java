package com.getyourguide.supplier.exception;

import lombok.Getter;

@Getter
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private final ErrorCode code;

    public ServiceException(ErrorCode code, String errorMessage) {
        super(errorMessage);
        this.code = code;
    }

}
