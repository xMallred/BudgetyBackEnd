package com.budgety.model.user;

import lombok.Data;

@Data
public class SaveUserRequest {

  private String name;
  private String password;
  private String email;
  private String phoneNumber;
}
