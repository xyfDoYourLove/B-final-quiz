package com.example.demo.common.interceptor;

import com.example.demo.exception.BusinessError;
import com.example.demo.exception.EntityNotExistException;
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
  public BusinessError userValidExceptionHandle(MethodArgumentNotValidException exception) {
    BusinessError myError = new BusinessError();
    myError.setMessage(Objects.requireNonNull(exception.getBindingResult().getFieldError()).getDefaultMessage());
    log.error(Objects.requireNonNull(exception.getBindingResult().getFieldError()).getDefaultMessage());

    Map<String, String> details = exception.getBindingResult().getAllErrors()
            .stream().collect(Collectors.toMap(ObjectError::getCode, ObjectError::getDefaultMessage));
    myError.setDetails(details);
    return myError;
  }

  @ExceptionHandler(value = {EntityNotExistException.class})
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public BusinessError userIdNotExistExceptionHandle(EntityNotExistException exception) {
    BusinessError myError = new BusinessError();
    myError.setMessage(exception.getMessage());
    log.error(exception.getMessage());

    Map<String, String> details = new HashMap<>();
    details.put("id:"+exception.getFeildValue(), exception.getMessage());
    myError.setDetails(details);
    return myError;
  }
}
