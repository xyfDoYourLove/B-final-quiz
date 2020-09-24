package com.example.demo.common.interceptor;

import com.example.demo.exception.BusinessError;
import com.example.demo.exception.UserNotExistException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;
import java.util.Objects;

@RestControllerAdvice
@Slf4j
public class UserExceptionHandle {

  @ExceptionHandler(value = {MethodArgumentNotValidException.class})
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public BusinessError userValidExceptionHandle(MethodArgumentNotValidException exception) {
    BusinessError myError = new BusinessError();
    myError.setMessage(Objects.requireNonNull(exception.getBindingResult().getFieldError()).getDefaultMessage());
    log.error(Objects.requireNonNull(exception.getBindingResult().getFieldError()).getDefaultMessage());
    return myError;
  }

  @ExceptionHandler(value = {UserNotExistException.class})
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public BusinessError userIdNotExistExceptionHandle(UserNotExistException exception) {
    BusinessError myError = new BusinessError();
    myError.setMessage(exception.getMessage());
    log.error(exception.getMessage());
    return myError;
  }
}
