package com.project.demo.models.dtomodels;

import lombok.Data;

@Data
public class UserGuestEntityDto {

  private String id;

  private String name;

  private String email;

  private String rol;

  private String endAccessDate;

  private boolean active;
}
