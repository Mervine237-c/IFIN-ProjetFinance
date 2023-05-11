package com.esprit.ifin.entities;

import com.esprit.ifin.audit.Auditable;
import com.esprit.ifin.entities.enums.DocumentStatus;
import com.esprit.ifin.entities.enums.DocumentType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "document")
public class Document extends Auditable<String> {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private Long id;

  @Enumerated
  @Column(name = "type", nullable = false, length = 8)
  private DocumentType type;

  @Column(name = "expiration_date", nullable = false)
  private Date expirationDate;

  @Enumerated
  @Column(name = "status", nullable = false, length = 8)
  private DocumentStatus status;

  @Column(name = "content", nullable = false)
  private byte[] content;
}
