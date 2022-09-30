package com.getyourguide.supplier.exception;

import lombok.Getter;

@Getter
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private final ErrorCode code;
    private final OperationId operationId;

    public ServiceException(OperationId operationId, ErrorCode code, String errorMessage) {
        super(errorMessage);
        this.operationId = operationId;
        this.code = code;
    }

}
