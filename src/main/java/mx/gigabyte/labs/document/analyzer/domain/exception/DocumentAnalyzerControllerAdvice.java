package mx.gigabyte.labs.document.analyzer.domain.exception;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;

@ControllerAdvice
public class DocumentAnalyzerControllerAdvice {

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseBody
  public ErrorResponse handleValidationExceptions(
    MethodArgumentNotValidException ex) {
    ErrorResponse errorResponse = ErrorResponse.builder().build();
    errorResponse.setErrorCode(HttpStatus.BAD_REQUEST.value());
    errorResponse.setMessageError(HttpStatus.BAD_REQUEST.getReasonPhrase());
    errorResponse.setErrors(new ArrayList<>());
    ex.getBindingResult().getAllErrors().forEach(error -> {
      String fieldName = ((FieldError) error).getField();
      String errorMessage = error.getDefaultMessage();
      errorResponse.getErrors().add(Error.builder()
          .field(fieldName)
          .issue(errorMessage)
        .build());
    });
    return errorResponse;
  }

  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler(DataAccessException.class)
  @ResponseBody
  public ErrorResponse handleDataAccessException(DataAccessException dataAccessException) {
    ErrorResponse errorResponse = ErrorResponse.builder().build();
    errorResponse.setErrorCode(1001);
    errorResponse.setMessageError("Query Error.");
    errorResponse.setErrors(new ArrayList<>());
    errorResponse.getErrors().add(Error.builder()
        .issue("We have some problems fulfilling your request.")
      .build());
    return errorResponse;
  }

}
