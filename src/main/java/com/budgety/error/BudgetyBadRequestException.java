package com.budgety.error;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class BudgetyBadRequestException extends RuntimeException {

  private List<BudgetyError> budgetyErrors;

  public BudgetyBadRequestException(List<BudgetyError> budgetyErrors) {
    this.budgetyErrors = budgetyErrors;
  }

  public BudgetyBadRequestException(BudgetyError budgetyError) {
    this.budgetyErrors = new ArrayList<>();
    this.budgetyErrors.add(budgetyError);
  }
}
