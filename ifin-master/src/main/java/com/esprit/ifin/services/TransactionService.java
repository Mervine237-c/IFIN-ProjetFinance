package com.esprit.ifin.services;

import com.esprit.ifin.entities.Transaction;
import com.esprit.ifin.repositories.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
  private final TransactionRepository transactionRepository;

  public TransactionService(final TransactionRepository transactionRepository) {
    this.transactionRepository = transactionRepository;
  }

  public Transaction saveTransaction(final Transaction transaction) {
    return transactionRepository.save(transaction);
  }

  public Transaction getTransaction(final Long id) {
    return transactionRepository.getById(id);
  }

  public List<Transaction> getAllTransactionByAccountId(final Long id) {
    return transactionRepository.findByAccount_Id(id);
  }
}
