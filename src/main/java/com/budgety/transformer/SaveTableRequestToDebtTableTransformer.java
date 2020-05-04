package com.budgety.transformer;

import com.budgety.domain.DebtTable;
import com.budgety.model.table.DebtTableRequest;
import com.budgety.model.table.SaveTableRequest;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
public class SaveTableRequestToDebtTableTransformer {

  public List<DebtTable> transform(SaveTableRequest saveTableRequest, String email) {
    List<DebtTable> debtTables = new ArrayList<>();

    if (!CollectionUtils.isEmpty(saveTableRequest.getDebtTableRequest())) {
      List<DebtTableRequest> debtTableRequests = saveTableRequest.getDebtTableRequest();
      for (DebtTableRequest debtTableRequest: debtTableRequests) {
        DebtTable debtTable = new DebtTable();
        debtTable.setName(debtTableRequest.getName());
        debtTable.setPrincipalAmount(debtTableRequest.getPrincipalAmount());
        debtTable.setStartingBalance(debtTableRequest.getStartingBalance());
        debtTable.setBalanceAsOf(debtTableRequest.getBalanceAsOf());
        debtTable.setAmountPaidAsOf(debtTableRequest.getAmountPaidAsOf());
        debtTable.setInterestAccrued(debtTableRequest.getInterestAccrued());
        debtTable.setEmail(email);
        debtTables.add(debtTable);
      }
    }

    return debtTables;
  }
}
