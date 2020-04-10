package com.budgety.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "UserCollection")
public class User {

  @Id
  private String id;
  private String name;
  private String password;
  private String email;
  private String phoneNumber;
  private String salad;
}
