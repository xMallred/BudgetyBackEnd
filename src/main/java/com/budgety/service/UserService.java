package com.budgety.service;

import com.budgety.domain.User;
import com.budgety.error.BudgetyBadRequestException;
import com.budgety.error.BudgetyError;
import com.budgety.model.user.SaveUserRequest;
import com.budgety.repository.UserRepository;
import com.budgety.security.PasswordUtils;
import com.budgety.transformer.SaveUserRequestToUserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private SaveUserRequestToUserTransformer saveUserRequestToUserTransformer;

  public void login(String email, String password) {
    User user = userRepository.findByEmail(email);
    if (user == null || !PasswordUtils.isExpectedPassword(password, user.getPassword(), user.getSalad())) {
      throw new BudgetyBadRequestException(new BudgetyError("Email or Password is Incorrect", HttpStatus.BAD_REQUEST));
    }
  }

  public void saveUser(SaveUserRequest saveUserRequest) {
    if (emailExists(saveUserRequest.getEmail())) {
      throw new BudgetyBadRequestException(new BudgetyError("Email already has account associated", HttpStatus.BAD_REQUEST));
    }
    User user = saveUserRequestToUserTransformer.transform(saveUserRequest);
    userRepository.insert(user);
  }

  public Boolean emailExists(String email) {
    User user = userRepository.findByEmail(email);
    Boolean userFound = false;
    if (user != null) {
      userFound = true;
    }
    return userFound;
  }
}
