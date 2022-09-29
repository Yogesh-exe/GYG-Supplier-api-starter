package com.getyourguide.supplier.exception;


public class InvalidReservationException extends ServiceException {
    private static final long serialVersionUID = 1L;

    public InvalidReservationException(OperationId operationId, String message) {
        super(operationId, ErrorCode.INVALID_RESERVATION, message);
    }
}
