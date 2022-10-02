package com.getyourguide.supplier.controller.advice;

import com.getyourguide.connectivity.supplierapi.openapi.model.ErrorResponseAvailabilityDTO;
import com.getyourguide.supplier.exception.ServiceException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice()
@Slf4j
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<Object> handleServiceException(ServiceException e) {

        switch (e.getOperationId()){
            case GET_AVAILABILITY:
                return this.handleGetAvailabilityException(e);
            case RESERVE:
                return this.handleReserveException(e);
            case CANCEL_RESERVATION:
                return this.handleCancelReserveException(e);
            case BOOK:
                return this.handleBookException(e);
            case CANCEL_BOOKING:
                return this.handleCancelBookingException(e);
            case DEFAULT:
                return this.handleDefaultException(e);
            default:
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleServiceException(Exception e) {
        DefaultErrorResponse defaultErrorResponse =
            new DefaultErrorResponse(999, "Please contact mycompany for the error investigation");
        return ResponseEntity.ok(defaultErrorResponse);
    }

    //TODO: Yogesh provide the mapping for all;
    private ResponseEntity<Object> handleGetAvailabilityException(ServiceException e) {
        ErrorResponseAvailabilityDTO error = new ErrorResponseAvailabilityDTO();
        error.setErrorCode(ErrorResponseAvailabilityDTO.ErrorCodeEnum.valueOf(e.getCode().name()));
        return ResponseEntity.ok(error);
    }

    private ResponseEntity<Object> handleDefaultException(ServiceException e) {
        return null;
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
        private final Integer errorcode;
        private final String errorMessage;
    }
}
