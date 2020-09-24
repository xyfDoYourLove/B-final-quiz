package com.example.demo.exception;

import java.util.function.Supplier;

public class TraineeNotExistException extends RuntimeException {

  private final String errorMessage;

  public TraineeNotExistException(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  @Override
  public String getMessage() {
    return errorMessage;
  }
}
