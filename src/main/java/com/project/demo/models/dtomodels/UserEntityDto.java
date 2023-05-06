package com.project.demo.models.dtomodels;

import com.project.demo.enums.Roles.Rol;
import lombok.Data;


@Data
public class UserEntityDto {

  private String id;

  private String name;

  private String photo;

  private String email;

  private Rol roles;

  private String endAccessDate;

  private boolean active;

}
