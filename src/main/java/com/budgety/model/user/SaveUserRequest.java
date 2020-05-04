package com.budgety.model.user;

import lombok.Data;

@Data
public class SaveUserRequest {

  private String firstName;
  private String lastName;
  private String password;
  private String email;
  private String phoneNumber;
}
