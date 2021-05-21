package dawidw.creditapp.credit.exception;

import feign.FeignException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private static final String MICROSERVICE_COMMUNICATION_EXCEPTION = "Error during communication with microservices";

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return getBadRequestResponse(ex);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolationException(Throwable ex, WebRequest request) {
        return getBadRequestResponse(ex);
    }

    private ResponseEntity<Object> getBadRequestResponse(Throwable ex){
        return new ResponseEntity<>(new ErrorResponse(BAD_REQUEST.value(), BAD_REQUEST.getReasonPhrase(), ex.getMessage()), BAD_REQUEST);
    }

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<Object> handleFeignException(Throwable ex, WebRequest request) {
        return new ResponseEntity<>(new ErrorResponse(INTERNAL_SERVER_ERROR.value(), INTERNAL_SERVER_ERROR.getReasonPhrase(), MICROSERVICE_COMMUNICATION_EXCEPTION), INTERNAL_SERVER_ERROR);
    }

}
