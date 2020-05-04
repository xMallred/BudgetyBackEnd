package com.budgety.repository;

import com.budgety.domain.DebtTable;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DebtRepository extends MongoRepository<DebtTable, String> {

  @Override
  <S extends DebtTable> List<S> saveAll(Iterable<S> iterable);

  List<DebtTable> findAllByEmail(String email);
}
