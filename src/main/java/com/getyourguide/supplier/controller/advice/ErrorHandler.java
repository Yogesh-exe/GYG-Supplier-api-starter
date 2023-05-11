package com.getyourguide.supplier.controller.advice;

import com.getyourguide.supplier.exception.ErrorCode;
import com.getyourguide.supplier.exception.ServiceException;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice()
@Slf4j
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<DefaultErrorResponse> handleServiceException(ServiceException e) {
        DefaultErrorResponse defaultErrorResponse = DefaultErrorResponse.builder()
            .errorcode(e.getCode())
            .errorMessage(e.getMessage()).build();
        return ResponseEntity.ok(defaultErrorResponse);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<DefaultErrorResponse> handleServiceException(Exception e) {
        DefaultErrorResponse defaultErrorResponse =
            new DefaultErrorResponse(ErrorCode.INTERNAL_SYSTEM_FAILURE,
                "Please contact mycompany for the error investigation");
        return ResponseEntity.ok(defaultErrorResponse);
    }


    @Getter
    @Builder
    private static class DefaultErrorResponse {
        private final ErrorCode errorcode;
        private final String errorMessage;
    }

}
