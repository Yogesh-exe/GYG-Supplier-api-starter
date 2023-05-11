package com.getyourguide.supplier.exception;

public class ValidationFailureException extends ServiceException {
    private static final long serialVersionUID = 1L;

    public ValidationFailureException(String message) {
        super(ErrorCode.VALIDATION_FAILURE, message);
    }
}
