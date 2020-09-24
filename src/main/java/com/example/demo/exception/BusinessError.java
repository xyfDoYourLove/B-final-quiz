package com.example.demo.exception;

import lombok.Data;

import java.util.Map;

@Data
public class BusinessError {

  private String message;

  private Map<String, String> details;

}
