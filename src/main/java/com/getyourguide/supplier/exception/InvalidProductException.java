package com.getyourguide.supplier.exception;

public class InvalidProductException extends ServiceException {
    private static final long serialVersionUID = 1L;

    public InvalidProductException(String message) {
        super(ErrorCode.INVALID_PRODUCT, message);
    }
}
