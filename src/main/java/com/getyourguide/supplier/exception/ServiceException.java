package com.getyourguide.supplier.exception;

import lombok.Getter;

@Getter
public class ServiceException extends RuntimeException {

    private final ErrorCode code;
    private final OperationId operationId;
    private static final long serialVersionUID = 1L;

    public ServiceException(OperationId operationId, ErrorCode code, String errorMessage) {
        super(errorMessage);
        this.operationId=operationId;
        this.code = code;
    }

}
