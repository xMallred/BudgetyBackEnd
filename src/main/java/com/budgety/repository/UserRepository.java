package com.budgety.repository;

import com.budgety.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

  @Override
  <S extends User> S insert(S s);

  User findByEmailAndPassword(String email, String password);

  User findByEmail(String email);
}
