package com.budgety.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "BudgetTableCollection")
public class BudgetTable {

  @Id
  private String email;
  private String pay;
  private String payFrequency;
  private String nextPayDate;
  private String budgetLength;
  private String dates;
  private String balances;
}
