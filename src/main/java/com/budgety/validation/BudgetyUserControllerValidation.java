package com.budgety.validation;

import com.budgety.error.BudgetyBadRequestException;
import com.budgety.error.BudgetyError;
import com.budgety.model.user.UserLoginRequest;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
public class BudgetyUserControllerValidation {

  public void validateLogin(UserLoginRequest userLoginRequest) {
    List<BudgetyError> errors = new ArrayList<>();
    if (StringUtils.isBlank(userLoginRequest.getEmail())) {
      errors.add(new BudgetyError("Email Must not be blank", HttpStatus.BAD_REQUEST));
    }

    if (StringUtils.isBlank(userLoginRequest.getPassword())) {
      errors.add(new BudgetyError("Password Must not be blank", HttpStatus.BAD_REQUEST));
    }

    if (!CollectionUtils.isEmpty(errors)) {
      throw new BudgetyBadRequestException(errors);
    }
  }
}
