package com.budgety.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "DebtTableCollection")
public class DebtTable {

  @Id
  private String id;
  private String name;
  private String principalAmount;
  private String startingBalance;
  private String balanceAsOf;
  private String amountPaidAsOf;
  private String interestAccrued;
  private String email;
}
