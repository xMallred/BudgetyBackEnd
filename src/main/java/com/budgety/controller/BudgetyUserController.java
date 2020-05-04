package com.budgety.controller;

import com.budgety.model.user.SaveUserRequest;
import com.budgety.model.user.UserLoginRequest;
import com.budgety.service.UserService;
import com.budgety.validation.BudgetyUserControllerValidation;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class BudgetyUserController {

  @Autowired
  private UserService userService;

  @Autowired
  private BudgetyUserControllerValidation budgetyUserControllerValidation;

  @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
  public ResponseEntity saveUser(@RequestBody SaveUserRequest saveUserRequest, HttpServletResponse response) {
    log.info("received request for email: {}", saveUserRequest.getEmail());
    budgetyUserControllerValidation.validateSaveUser(saveUserRequest);
    userService.saveUser(saveUserRequest, response);
    return new ResponseEntity(HttpStatus.OK);
  }

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public ResponseEntity login(@RequestBody UserLoginRequest userLoginRequest, HttpServletResponse response) {
    log.info("received request for email: {}", userLoginRequest.getEmail());
    budgetyUserControllerValidation.validateLogin(userLoginRequest);
    userService.login(userLoginRequest.getEmail(), userLoginRequest.getPassword(), response);
    return new ResponseEntity(HttpStatus.OK);
  }
}
