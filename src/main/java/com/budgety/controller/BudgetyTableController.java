package com.budgety.controller;

import com.budgety.model.table.BudgetTableResponse;
import com.budgety.model.table.SaveTableRequest;
import com.budgety.service.TableService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BudgetyTableController {

  @Autowired
  private TableService tableService;

  @RequestMapping(value = "/setTable", method = RequestMethod.POST)
  public ResponseEntity setTable(@RequestBody SaveTableRequest saveTableRequest, HttpServletRequest request) {
    tableService.saveTable(saveTableRequest, request);
    return new ResponseEntity(HttpStatus.OK);
  }

  @RequestMapping(value = "/retrieveTable", method = RequestMethod.POST)
  public ResponseEntity<BudgetTableResponse> retrieveTable(HttpServletRequest request) {
    BudgetTableResponse budgetTableResponse = tableService.retrieveTable(request);
    return new ResponseEntity<>(budgetTableResponse, HttpStatus.OK);
  }
}
