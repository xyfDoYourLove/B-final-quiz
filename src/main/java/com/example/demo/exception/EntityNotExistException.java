package com.example.demo.exception;

import java.util.function.Supplier;

public class EntityNotExistException extends RuntimeException {

  private final String errorMessage;

  public EntityNotExistException(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  @Override
  public String getMessage() {
    return errorMessage;
  }
}
