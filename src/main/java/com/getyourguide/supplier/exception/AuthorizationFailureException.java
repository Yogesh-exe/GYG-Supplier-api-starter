package com.getyourguide.supplier.exception;

public class AuthorizationFailureException extends ServiceException {
    private static final long serialVersionUID = 1L;

    public AuthorizationFailureException(String message) {
        super(ErrorCode.AUTHORIZATION_FAILURE, message);
    }
}
