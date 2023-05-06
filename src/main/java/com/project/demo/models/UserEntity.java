package com.project.demo.models;

import com.project.demo.enums.Roles.Rol;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity extends AuditEntity {

  @Column
  private String name;

  @Column
  private String email;

  @Column
  private String photo;

  @Column
  @Enumerated(EnumType.STRING)
  private Rol roles;

  @Column
  private Long endAccessDate;

  @Column
  private boolean active;
}
