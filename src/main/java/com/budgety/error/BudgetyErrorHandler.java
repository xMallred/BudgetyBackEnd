package com.budgety.error;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BudgetyErrorHandler {

  @ExceptionHandler(BudgetyBadRequestException.class)
  public ResponseEntity<List<BudgetyError>> handleError(BudgetyBadRequestException budgetyBadRequestException) {
    return new ResponseEntity<>(budgetyBadRequestException.getBudgetyErrors(), HttpStatus.BAD_REQUEST);
  }
}
