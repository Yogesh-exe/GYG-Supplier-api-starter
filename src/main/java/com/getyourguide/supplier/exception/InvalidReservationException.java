package com.getyourguide.supplier.exception;


public class InvalidReservationException extends ServiceException {
    private static final long serialVersionUID = 1L;

    public InvalidReservationException(String message) {
        super(ErrorCode.INVALID_RESERVATION, message);
    }
}
