package com.getyourguide.supplier.exception;

public class InvalidProductException extends ServiceException {
    private static final long serialVersionUID = 1L;

    public InvalidProductException(OperationId operationId, String message) {
        super(operationId, ErrorCode.INVALID_PRODUCT, message);
    }
}
