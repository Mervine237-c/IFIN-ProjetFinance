package com.esprit.ifin.entities;

import com.esprit.ifin.audit.Auditable;
import com.esprit.ifin.entities.enums.PersonType;
import com.esprit.ifin.entities.enums.Role;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
@Table(name = "users")
public class User extends Auditable<String> {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "name", nullable = false, length = 64)
  private String name;

  @Column(name = "surname", nullable = false, length = 64)
  private String Surname;

  @Column(name = "address", nullable = false, length = 64)
  private String address;

  @Column(name = "nationality", nullable = false, length = 64)
  private String nationality;

  @Column(name = "email", nullable = false, length = 64)
  private String email;

  @Column(name = "password", nullable = false, length = 64)
  private String password;

  @Column(name = "phone", length = 64)
  private String phone;

  @Column(name = "cin_number", nullable = false, length = 64)
  private Long cinNumber;

  @Column(name = "date_of_birth", nullable = false, length = 64)
  private Date dateOfBirth;

  @Enumerated(EnumType.STRING)
  @Column(name = "role", nullable = false, length = 8)
  private Role role;

  @Enumerated(EnumType.STRING)
  @Column(name = "person_type", nullable = false, length = 16)
  private PersonType personType;

}
