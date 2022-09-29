package com.getyourguide.supplier.controller.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice()
@Slf4j
public class ErrorHandler extends ResponseEntityExceptionHandler {

//    @ExceptionHandler(ServiceException.class)
//    public ResponseEntity<Object> handleServiceException(ServiceException e) {
//
//        var error = new ErrorResponse()
//            .errorCode(e.getCode())
//            .errorMessage(e.getMessage());
//        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
//    }

}
