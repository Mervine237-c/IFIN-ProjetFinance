package com.esprit.ifin.repositories;

import com.esprit.ifin.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
  List<Account> findByUser_Id(Long id);
}
