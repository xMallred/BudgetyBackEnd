package com.budgety.transformer;

import com.budgety.domain.ExpenseTable;
import com.budgety.model.table.BudgetTableRequest;
import com.budgety.model.table.Expense;
import com.budgety.model.table.SaveTableRequest;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class SaveTableRequestToExpenseTableTransformer {

  public List<ExpenseTable> transform(SaveTableRequest saveTableRequest, String email) {
    BudgetTableRequest budgetTableRequest = saveTableRequest.getBudgetTableRequest();

    List<Expense> expenses = budgetTableRequest.getExpenses();

    List<ExpenseTable> expenseTables = new ArrayList<>();
    for (Expense expense: expenses) {
      ExpenseTable expenseTable = new ExpenseTable();
      expenseTable.setSequence(expense.getSequence());
      expenseTable.setName(expense.getName());
      expenseTable.setAmounts(String.join(",", expense.getAmounts()));
      expenseTable.setEmail(email);
      expenseTables.add(expenseTable);
    }

    return expenseTables;
  }
}
