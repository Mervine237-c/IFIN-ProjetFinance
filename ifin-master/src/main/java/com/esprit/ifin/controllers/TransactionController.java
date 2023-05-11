package com.esprit.ifin.controllers;

import com.esprit.ifin.entities.Transaction;
import com.esprit.ifin.services.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransactionController {
  private final TransactionService transactionService;

  public TransactionController(final TransactionService transactionService) {
    this.transactionService = transactionService;
  }

  @PostMapping("/transaction")
  public ResponseEntity<Transaction> saveTransaction(@RequestBody final Transaction transaction) {
    return new ResponseEntity<>(
        transactionService.saveTransaction(transaction), HttpStatus.CREATED);
  }

  @GetMapping("/transaction/{id}")
  public ResponseEntity<Transaction> getTransaction(@PathVariable final Long id) {
    return new ResponseEntity<>(transactionService.getTransaction(id), HttpStatus.OK);
  }
}
