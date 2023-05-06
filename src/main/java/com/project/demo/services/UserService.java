package com.project.demo.services;

import com.project.demo.models.UserEntity;
import java.util.List;

public interface UserService {

  List<UserEntity> retrieveAllUsers();

  UserEntity addNewUserEntity(UserEntity newUserEntity);

  UserEntity updateUserEntity(UserEntity updatedUserEntity);

  void deleteUser(String id);

  Long returnUser(String username);

  Long returnEmail(String email);

  UserEntity refreshUser(String id);

  void deleteAllUsers();

}
