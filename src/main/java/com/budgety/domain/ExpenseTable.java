package com.budgety.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "ExpenseTableCollection")
public class ExpenseTable {

  @Id
  private String id;
  private String name;
  private String amounts;
  private Integer sequence;
  private String email;
}
