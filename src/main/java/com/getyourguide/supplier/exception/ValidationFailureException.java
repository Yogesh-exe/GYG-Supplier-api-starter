package com.getyourguide.supplier.exception;

public class ValidationFailureException extends ServiceException {
    private static final long serialVersionUID = 1L;

    public ValidationFailureException(OperationId operationId, String message) {
        super(operationId, ErrorCode.VALIDATION_FAILURE, message);
    }
}
