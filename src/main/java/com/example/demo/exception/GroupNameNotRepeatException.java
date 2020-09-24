package com.example.demo.exception;

public class GroupNameNotRepeatException extends RuntimeException {

  private final String errorMessage;

  private final String filedValue;

  public GroupNameNotRepeatException(String errorMessage, String feildValue) {
    this.errorMessage = errorMessage;
    this.filedValue = feildValue;
  }

  @Override
  public String getMessage() {
    return errorMessage;
  }

  public String getFiledValue() {
    return filedValue;
  }
}
