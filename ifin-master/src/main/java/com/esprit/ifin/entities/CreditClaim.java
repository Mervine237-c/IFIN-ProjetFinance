package com.esprit.ifin.entities;

import com.esprit.ifin.audit.Auditable;
import com.esprit.ifin.entities.enums.ClaimStatus;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "credit_claim")
public class CreditClaim extends Auditable<String> {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "description", nullable = false, length = 255)
  private String description;

  @Enumerated
  @Column(name = "claim_status", nullable = false, length = 8)
  private ClaimStatus claimStatus;
}
