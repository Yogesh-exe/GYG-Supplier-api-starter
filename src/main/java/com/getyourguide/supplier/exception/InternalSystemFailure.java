package com.getyourguide.supplier.exception;

public class InternalSystemFailure extends ServiceException {
    private static final long serialVersionUID = 1L;

    public InternalSystemFailure(String message) {
        super(ErrorCode.INTERNAL_SYSTEM_FAILURE, message);
    }
}
