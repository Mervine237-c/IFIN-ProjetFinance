package com.esprit.ifin.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "agency")
public class Agency {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "address", nullable = false, length = 64)
  private String address;

  @Column(name = "name", nullable = false, length = 64)
  private String name;

  @Column(name = "phone", length = 64)
  private String phone;

  @Column(name = "email", nullable = false, length = 64)
  private String email;
}
