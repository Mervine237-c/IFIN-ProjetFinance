package com.esprit.ifin.entities;

import com.esprit.ifin.audit.Auditable;
import com.esprit.ifin.entities.enums.AccountType;
import com.esprit.ifin.entities.enums.BusinessSector;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "account")
public class Account extends Auditable<String> {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "iban", nullable = false, length = 64)
  private String iban;

  @Column(name = "balance")
  private float balance;

  @Column(name = "name", nullable = false, length = 64)
  private String name;

  @Enumerated(EnumType.STRING)
  @Column(name = "business_sector", nullable = false, length = 16)
  private BusinessSector businessSector;

  @Enumerated(EnumType.STRING)
  @Column(name = "type", nullable = false, length = 8)
  private AccountType type;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "user_id")
  private User user;
}
