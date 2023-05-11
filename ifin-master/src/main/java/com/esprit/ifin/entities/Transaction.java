package com.esprit.ifin.entities;

import com.esprit.ifin.audit.Auditable;
import com.esprit.ifin.entities.enums.TransactionType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "transaction")
public class Transaction extends Auditable<String> {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "iban_sender", nullable = false, length = 64)
  private String ibanSender;

  @Column(name = "iban_receiver", nullable = false, length = 64)
  private String ibanReceiver;

  @Column(name = "amount")
  private float amount;

  @Column(name = "description", nullable = false, length = 255)
  private String description;

  @Enumerated
  @Column(name = "type", nullable = false, length = 16)
  private TransactionType type;

  @Column(name = "execution_date", nullable = false)
  private Date executionDate;

  @ManyToOne
  @JoinColumn(name = "account_id")
  private Account account;
}
