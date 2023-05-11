package com.esprit.ifin.services;

import com.esprit.ifin.entities.Account;
import com.esprit.ifin.helpers.IbanGenerator;
import com.esprit.ifin.repositories.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
  private final AccountRepository accountRepository;

  public AccountService(final AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  public Account saveAccount(final Account account) {
    account.setIban(IbanGenerator.calculateIBAN());
    return accountRepository.save(account);
  }

  public Account getAccount(final Long id) {
    return accountRepository.getById(id);
  }

  public List<Account> getAllAccountsByUser(final Long idUser) {
    return accountRepository.findByUser_Id(idUser);
  }

  public void deleteAccountById(final Long id) {
    accountRepository.deleteById(id);
  }

  public Account updateAccount(final Account account) {
    return accountRepository.save(account);
  }
}
