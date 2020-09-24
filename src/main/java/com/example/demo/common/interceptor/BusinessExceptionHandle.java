package com.example.demo.common.interceptor;

import com.example.demo.exception.BusinessError;
import com.example.demo.exception.EntityNotExistException;
import com.example.demo.exception.GroupNameNotRepeatException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class BusinessExceptionHandle {

  @ExceptionHandler(value = {MethodArgumentNotValidException.class})
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public BusinessError entityValidExceptionHandle(MethodArgumentNotValidException exception) {
    BusinessError businessError = new BusinessError();
    businessError.setMessage(Objects.requireNonNull(exception.getBindingResult().getFieldError()).getDefaultMessage());
    log.error(Objects.requireNonNull(exception.getBindingResult().getFieldError()).getDefaultMessage());

    Map<String, String> details = exception.getBindingResult().getAllErrors()
            .stream().collect(Collectors.toMap(ObjectError::getCode, ObjectError::getDefaultMessage));
    businessError.setDetails(details);
    return businessError;
  }

  @ExceptionHandler(value = {EntityNotExistException.class})
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public BusinessError entityNotExistExceptionHandle(EntityNotExistException exception) {
    BusinessError businessError = new BusinessError();
    businessError.setMessage(exception.getMessage());
    log.error(exception.getMessage());

    Map<String, String> details = new HashMap<>();
    details.put("id:"+exception.getFiledValue(), exception.getMessage());
    businessError.setDetails(details);
    return businessError;
  }

  @ExceptionHandler(value = {GroupNameNotRepeatException.class})
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public BusinessError groupNameNotRepeatExceptionHandle(EntityNotExistException exception) {
    BusinessError businessError = new BusinessError();
    businessError.setMessage(exception.getMessage());
    log.error(exception.getMessage());

    Map<String, String> details = new HashMap<>();
    details.put("name:"+exception.getFiledValue(), exception.getMessage());
    businessError.setDetails(details);
    return businessError;
  }
}
