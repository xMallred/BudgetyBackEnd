package com.budgety.model.table;

import java.util.List;
import lombok.Data;

@Data
public class Expense {
  private String name;
  private List<String> amounts;
  private Integer sequence;
}
