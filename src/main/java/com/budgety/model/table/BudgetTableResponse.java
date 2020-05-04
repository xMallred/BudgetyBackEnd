package com.budgety.model.table;

import java.util.List;
import lombok.Data;

@Data
public class BudgetTableResponse {

  private List<String> dates;
  private List<Expense> expenses;
  private List<String> balances;
}
