package com.budgety.service;

import com.budgety.domain.DebtTable;
import com.budgety.domain.ExpenseTable;
import com.budgety.domain.BudgetTable;
import com.budgety.model.table.BudgetTableResponse;
import com.budgety.model.table.SaveTableRequest;
import com.budgety.repository.DebtRepository;
import com.budgety.repository.ExpenseRepository;
import com.budgety.repository.TableRepository;
import com.budgety.transformer.SaveTableRequestToDebtTableTransformer;
import com.budgety.transformer.SaveTableRequestToExpenseTableTransformer;
import com.budgety.transformer.SaveTableRequestToUserInformationTransformation;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
@Slf4j
public class TableService {

  @Autowired
  private TableRepository tableRepository;

  @Autowired
  private ExpenseRepository expenseRepository;

  @Autowired
  private DebtRepository debtRepository;

  @Autowired
  private SaveTableRequestToUserInformationTransformation saveTableRequestToUserInformationTransformation;

  @Autowired
  private SaveTableRequestToExpenseTableTransformer saveTableRequestToExpenseTableTransformer;

  @Autowired
  private SaveTableRequestToDebtTableTransformer saveTableRequestToDebtTableTransformer;

  public void saveTable(SaveTableRequest saveTableRequest, HttpServletRequest request) {
    String email = getEmail(request);

    if (StringUtils.isNotBlank(email)) {
      log.info("Setting Tables for user: " + email);

      BudgetTable budgetTable = saveTableRequestToUserInformationTransformation.transform(saveTableRequest, email);
      tableRepository.save(budgetTable);

      List<ExpenseTable> existingExpenseTables = expenseRepository.findAllByEmail(email);
      if (!CollectionUtils.isEmpty(existingExpenseTables)) {
        expenseRepository.deleteAll(existingExpenseTables);
      }
      List<ExpenseTable> expenseTables = saveTableRequestToExpenseTableTransformer.transform(saveTableRequest, email);
      if (!CollectionUtils.isEmpty(expenseTables)) {
        expenseRepository.saveAll(expenseTables);
      }

      List<DebtTable> existingDebtTables = debtRepository.findAllByEmail(email);
      if (!CollectionUtils.isEmpty(existingDebtTables)) {
        debtRepository.deleteAll(existingDebtTables);
      }

      List<DebtTable> debtTables = saveTableRequestToDebtTableTransformer.transform(saveTableRequest, email);
      if (!CollectionUtils.isEmpty(debtTables)) {
        debtRepository.saveAll(debtTables);
      }
    }
  }

  public BudgetTableResponse retrieveTable(HttpServletRequest request) {
    String email = getEmail(request);
    return new BudgetTableResponse();
  }

  private String getEmail(HttpServletRequest request) {
    String email = null;
    Cookie[] cookies = request.getCookies();
    for (Cookie cookie: cookies) {
      if (StringUtils.equals("Email", cookie.getName())) {
        email = cookie.getValue();
      }
    }
    return email;
  }
}
