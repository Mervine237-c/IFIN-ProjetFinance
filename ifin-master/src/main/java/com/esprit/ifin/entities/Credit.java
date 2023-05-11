package com.esprit.ifin.entities;

import com.esprit.ifin.audit.Auditable;
import com.esprit.ifin.entities.enums.CreditStatus;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "credit")
public class Credit extends Auditable<String> {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "amount", nullable = false, length = 64)
  private float amount;

  @Column(name = "interest_rate", nullable = false, length = 64)
  private float interestRate;

  @Column(name = "salary", nullable = false, length = 64)
  private float salary;

  @Column(name = "annuity", nullable = false, length = 64)
  private float annuity;

  @Column(name = "duration", nullable = false, length = 64)
  private float duration;

  @Enumerated
  @Column(name = "status", nullable = false, length = 8)
  private CreditStatus status;
}
