package com.example.demo.exception;

import java.util.function.Supplier;

public class EntityNotExistException extends RuntimeException {

  private final String errorMessage;

  private final String feildValue;

  public EntityNotExistException(String errorMessage, String feildValue) {
    this.errorMessage = errorMessage;
    this.feildValue = feildValue;
  }

  @Override
  public String getMessage() {
    return errorMessage;
  }

  public String getFeildValue() {
    return feildValue;
  }
}
