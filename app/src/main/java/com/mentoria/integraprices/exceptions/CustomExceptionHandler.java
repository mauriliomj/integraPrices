package com.mentoria.integraprices.exceptions;

import com.mentoria.integraprices.gateways.inputs.jsons.ErrorResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestControllerAdvice
public class CustomExceptionHandler {

  private static final String CONTENT_TYPE = "Content-Type";
  private static final String APPLICATION_JSON_CHARSET_UTF_8 =
      "application/json; charset=utf-8";

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public HttpEntity<ErrorResponse>
  handlerValidationException(final MethodArgumentNotValidException ex) {

    final BindingResult bindingResult = ex.getBindingResult();
    final List<FieldError> fieldErrors = bindingResult.getFieldErrors();
    final ErrorResponse response = this.processFieldErrors(fieldErrors);
    HttpHeaders responseHeaders = new HttpHeaders();
    responseHeaders.add(CONTENT_TYPE, APPLICATION_JSON_CHARSET_UTF_8);
    return new ResponseEntity<>(response, responseHeaders, HttpStatus.BAD_REQUEST);

  }

  @ExceptionHandler(NotFoundException.class)
  public HttpEntity<ErrorResponse> handlerValidationException(final NotFoundException ex) {

    List<String> errors = new ArrayList<>();
    errors.add(ex.getMessage());
    final ErrorResponse response = new ErrorResponse(errors);
    HttpHeaders responseHeaders = new HttpHeaders();
    responseHeaders.add(CONTENT_TYPE, APPLICATION_JSON_CHARSET_UTF_8);
    return new ResponseEntity<>(response, responseHeaders, HttpStatus.NOT_FOUND);

  }

  @ExceptionHandler(AlreadyRegisteredException.class)
  public HttpEntity<ErrorResponse> handlerValidationException(final AlreadyRegisteredException ex) {

    List<String> errors = new ArrayList<>();
    errors.add(ex.getMessage());
    final ErrorResponse response = new ErrorResponse(errors);
    HttpHeaders responseHeaders = new HttpHeaders();
    responseHeaders.add(CONTENT_TYPE, APPLICATION_JSON_CHARSET_UTF_8);
    return new ResponseEntity<>(response, responseHeaders, HttpStatus.BAD_REQUEST);

  }

  private ErrorResponse processFieldErrors(final List<FieldError> fieldErrors) {

    final List<String> errors = fieldErrors.stream()
        .map(error -> String.format("%s: %s", error.getField(), error.getDefaultMessage()))
        .collect(toList());
    return new ErrorResponse(errors);

  }
}
