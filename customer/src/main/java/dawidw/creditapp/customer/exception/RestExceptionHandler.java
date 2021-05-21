package dawidw.creditapp.customer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    //todo logging

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleOtherErrors(Throwable ex, WebRequest request) {
        return new ResponseEntity<>(new ErrorResponse(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /*@ExceptionHandler(CreditAppException.class)
    public ResponseEntity handleCreditAppException(CreditAppException ex, WebRequest request) {

    }*/

}