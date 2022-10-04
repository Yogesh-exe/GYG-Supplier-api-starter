package com.getyourguide.supplier.controller.advice;

import com.getyourguide.connectivity.supplierapi.openapi.model.ErrorResponseAvailabilityDTO;
import com.getyourguide.supplier.exception.AuthorizationFailureException;
import com.getyourguide.supplier.exception.ErrorCode;
import com.getyourguide.supplier.exception.InvalidProductException;
import com.getyourguide.supplier.exception.ServiceException;
import com.getyourguide.supplier.exception.ValidationFailureException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice()
@Slf4j
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<Object> handleServiceException(ServiceException e) {

        return switch (e.getOperationId()) {
            case GET_AVAILABILITY -> this.handleGetAvailabilityException(e);
            case RESERVE -> this.handleReserveException(e);
            case CANCEL_RESERVATION -> this.handleCancelReserveException(e);
            case BOOK -> this.handleBookException(e);
            case CANCEL_BOOKING -> this.handleCancelBookingException(e);
            case DEFAULT -> this.handleDefaultException(e);
        };

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleServiceException(Exception e) {
        DefaultErrorResponse defaultErrorResponse =
            new DefaultErrorResponse(ErrorCode.INTERNAL_SYSTEM_FAILURE, "Please contact mycompany for the error investigation");
        return ResponseEntity.ok(defaultErrorResponse);
    }

    //TODO: Yogesh provide the mapping for all;
    private ResponseEntity<Object> handleGetAvailabilityException(ServiceException e) {
        ErrorResponseAvailabilityDTO error = new ErrorResponseAvailabilityDTO();
        error.setErrorCode(ErrorResponseAvailabilityDTO.ErrorCodeEnum.valueOf(e.getCode().name()));
        return ResponseEntity.ok(error);
    }

    private ResponseEntity<Object> handleDefaultException(ServiceException e) {
        ErrorCode errorCode = isSpecializedExceptionForDefault(e) ? e.getCode()
            : ErrorCode.INTERNAL_SYSTEM_FAILURE;

        DefaultErrorResponse error = new DefaultErrorResponse(errorCode,e.getMessage());
        return ResponseEntity.ok(error);
    }

    private ResponseEntity<Object> handleCancelBookingException(ServiceException e) {
        return null;
    }

    private ResponseEntity<Object> handleBookException(ServiceException e) {
        return null;
    }

    private ResponseEntity<Object> handleCancelReserveException(ServiceException e) {
        return null;
    }

    private ResponseEntity<Object> handleReserveException(ServiceException e) {
        return null;
    }

    @Data
    private static class DefaultErrorResponse{
        private final ErrorCode errorcode;
        private final String errorMessage;
    }

    private boolean isSpecializedExceptionForDefault(ServiceException exception){
        return exception instanceof AuthorizationFailureException
            || exception instanceof InvalidProductException
            || exception instanceof ValidationFailureException;
    }
}
