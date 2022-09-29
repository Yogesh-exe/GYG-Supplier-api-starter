package com.getyourguide.supplier.exception;

public class InternalSystemFailure extends ServiceException {
    private static final long serialVersionUID = 1L;

    public InternalSystemFailure(OperationId operationId, String message) {
        super(operationId, ErrorCode.INTERNAL_SYSTEM_FAILURE, message);
    }
}
