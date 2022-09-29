package com.getyourguide.supplier.exception;

public class InvalidBookingException extends ServiceException {
    private static final long serialVersionUID = 1L;

    public InvalidBookingException(OperationId operationId, String message) {
        super(operationId, ErrorCode.INVALID_BOOKING, message);
    }

}
