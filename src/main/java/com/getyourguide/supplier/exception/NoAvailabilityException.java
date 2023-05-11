package com.getyourguide.supplier.exception;

public class NoAvailabilityException extends ServiceException {
    private static final long serialVersionUID = 1L;

    public NoAvailabilityException(String message) {
        super(ErrorCode.NO_AVAILABILITY, message);
    }
}
