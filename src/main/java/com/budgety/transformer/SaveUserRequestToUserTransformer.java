package com.budgety.transformer;

import com.budgety.domain.User;
import com.budgety.model.user.SaveUserRequest;
import com.budgety.security.PasswordUtils;
import org.springframework.stereotype.Component;

@Component
public class SaveUserRequestToUserTransformer {

  public User transform(SaveUserRequest saveUserRequest) {
    User user = new User();
    user.setName(saveUserRequest.getFirstName() + " " + saveUserRequest.getLastName());
    user.setEmail(saveUserRequest.getEmail());
    String salt = PasswordUtils.getSalt();
    user.setPassword(PasswordUtils.generateSecuredPassword(saveUserRequest.getPassword(), salt));
    user.setSalad(salt);
    user.setPhoneNumber(saveUserRequest.getPhoneNumber());
    return user;
  }
}
