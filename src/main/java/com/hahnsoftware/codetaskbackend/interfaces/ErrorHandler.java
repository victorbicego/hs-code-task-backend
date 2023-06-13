package com.hahnsoftware.codetaskbackend.interfaces;

import com.hahnsoftware.codetaskbackend.exceptions.AttendantNotSubscribedException;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<Object> handleAttendantNotSubscribedException(AttendantNotSubscribedException ex,
            WebRequest request) {
        HttpHeaders headers = new HttpHeaders();
        return handleExceptionInternal(ex, null, headers, HttpStatus.BAD_REQUEST, request);
    }
}
