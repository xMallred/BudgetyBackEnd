package com.budgety.transformer;

import com.budgety.domain.BudgetTable;
import com.budgety.model.table.BudgetTableRequest;
import com.budgety.model.table.SaveTableRequest;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
public class SaveTableRequestToUserInformationTransformation {

  public BudgetTable transform(SaveTableRequest saveTableRequest, String email) {
    BudgetTable budgetTable = new BudgetTable();
    budgetTable.setEmail(email);
    budgetTable.setPay(saveTableRequest.getPay());
    budgetTable.setPayFrequency(saveTableRequest.getPayFrequency());
    budgetTable.setNextPayDate(saveTableRequest.getNextPayDate());
    budgetTable.setBudgetLength(saveTableRequest.getBudgetLength());

    if (saveTableRequest.getBudgetTableRequest() != null) {
      BudgetTableRequest budgetTableRequest = saveTableRequest.getBudgetTableRequest();
      List<String> balances = budgetTableRequest.getBalances();
      List<String> dates = budgetTableRequest.getDates();

      if (!CollectionUtils.isEmpty(balances)) {
        budgetTable.setBalances(String.join(",", balances));
      }

      if (!CollectionUtils.isEmpty(dates)) {
        budgetTable.setDates(String.join(",", dates));
      }
    }

    return budgetTable;
  }
}
