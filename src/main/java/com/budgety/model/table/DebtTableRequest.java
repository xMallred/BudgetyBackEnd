package com.budgety.model.table;

import lombok.Data;

@Data
public class DebtTableRequest {
  private String name;
  private String principalAmount;
  private String startingBalance;
  private String balanceAsOf;
  private String amountPaidAsOf;
  private String interestAccrued;
  private String email;
}
