package com.esprit.ifin.entities;

import com.esprit.ifin.audit.Auditable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
@Table(name = "appointment")
public class Appointment extends Auditable<String> {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false, length = 16)
  private Long id;

  @Column(name = "date", nullable = false)
  private LocalDateTime date;
}
