package com.budgety.error;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class BudgetyError {

  private String message;
  private HttpStatus status;

  public BudgetyError(String message, HttpStatus status) {
    this.message = message;
    this.status = status;
  }
}
