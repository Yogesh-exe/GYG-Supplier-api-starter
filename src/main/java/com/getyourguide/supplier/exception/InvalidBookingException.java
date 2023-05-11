package com.getyourguide.supplier.exception;

public class InvalidBookingException extends ServiceException {
    private static final long serialVersionUID = 1L;

    public InvalidBookingException(String message) {
        super(ErrorCode.INVALID_BOOKING, message);
    }

}
