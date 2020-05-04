package com.budgety.repository;

import com.budgety.domain.BudgetTable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableRepository extends MongoRepository<BudgetTable, String> {

  @Override
  <S extends BudgetTable> S insert(S s);

}
