package com.budgety.model.table;

import java.util.List;
import lombok.Data;

@Data
public class SaveTableRequest {
  private String pay;
  private String payFrequency;
  private String nextPayDate;
  private String budgetLength;
  private BudgetTableRequest budgetTableRequest;
  private List<DebtTableRequest> debtTableRequest;
}
