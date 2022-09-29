package com.getyourguide.supplier.exception;

public class NoAvailabilityException extends ServiceException {
    private static final long serialVersionUID = 1L;

    public NoAvailabilityException(OperationId operationId, String message) {
        super(operationId, ErrorCode.NO_AVAILABILITY, message);
    }
}
