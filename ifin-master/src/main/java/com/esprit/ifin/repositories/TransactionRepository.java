package com.esprit.ifin.repositories;

import com.esprit.ifin.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
  List<Transaction> findByAccount_Id(Long id);
}
