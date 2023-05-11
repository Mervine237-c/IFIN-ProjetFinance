package com.esprit.ifin.controllers;

import com.esprit.ifin.entities.Account;
import com.esprit.ifin.services.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {
  private final AccountService accountService;

  public AccountController(final AccountService accountService) {
    this.accountService = accountService;
  }

  @PostMapping("/account")
  public ResponseEntity<Account> saveAccount(@RequestBody final Account account) {
    return new ResponseEntity<>(accountService.saveAccount(account), HttpStatus.CREATED);
  }

  @GetMapping("/account/{id}")
  public ResponseEntity<Account> getAccount(@PathVariable final Long id) {
    return new ResponseEntity<>(accountService.getAccount(id), HttpStatus.OK);
  }

  @GetMapping("/account/{idUser}")
  public ResponseEntity<List<Account>> getAllAccountsByUser(@PathVariable final Long idUser) {
    return new ResponseEntity<>(accountService.getAllAccountsByUser(idUser), HttpStatus.OK);
  }

  @DeleteMapping("/account/{id}")
  public ResponseEntity<?> deleteAccountById(@PathVariable final Long id) {
    accountService.deleteAccountById(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @PutMapping("/account")
  public ResponseEntity<Account> updateAccount(@RequestBody final Account account) {
    return new ResponseEntity<>(accountService.updateAccount(account), HttpStatus.ACCEPTED);
  }
}
