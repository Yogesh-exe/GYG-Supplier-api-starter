package com.getyourguide.supplier.exception;

public class AuthorizationFailureException extends ServiceException {
    private static final long serialVersionUID = 1L;

    public AuthorizationFailureException(OperationId operationId, String message) {
        super(operationId, ErrorCode.AUTHORIZATION_FAILURE, message);
    }
}
