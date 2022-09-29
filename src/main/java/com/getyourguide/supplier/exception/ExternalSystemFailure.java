package com.getyourguide.supplier.exception;

public class ExternalSystemFailure extends ServiceException {
    private static final long serialVersionUID = 1L;

    public ExternalSystemFailure(OperationId operationId, String message) {
        super(operationId, ErrorCode.INTERNAL_SYSTEM_FAILURE, message);
    }
}
