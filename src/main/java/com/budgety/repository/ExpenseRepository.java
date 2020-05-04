package com.budgety.repository;

import com.budgety.domain.ExpenseTable;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends MongoRepository<ExpenseTable, String> {

  @Override
  <S extends ExpenseTable> List<S> saveAll(Iterable<S> iterable);

  @Override
  void deleteAll(Iterable<? extends ExpenseTable> iterable);

  List<ExpenseTable> findAllByEmail(String email);
}
