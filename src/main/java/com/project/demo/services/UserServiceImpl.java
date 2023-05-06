package com.project.demo.services;

import com.project.demo.enums.Roles.Rol;
import com.project.demo.models.UserEntity;
import com.project.demo.repositories.UserRepository;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public List<UserEntity> retrieveAllUsers() {
    return (List<UserEntity>) userRepository.findAll();
  }

  @Override
  public UserEntity addNewUserEntity(UserEntity newUserEntity) {
    if (newUserEntity.getRoles() == Rol.GUEST) {
      newUserEntity.setEndAccessDate(new Date().getTime() + 86400000);
    }
    return userRepository.save(newUserEntity);
  }

  @Override
  public UserEntity updateUserEntity(UserEntity updatedUserEntity) {
    return userRepository.save(updatedUserEntity);
  }

  @Override
  public void deleteUser(String id) {
    /*Pendiente hacer que el usuario admin no pueda ser borrado*/
    userRepository.deleteById(UUID.fromString(id));
  }

  @Override
  public Long returnUser(String username) {
    return userRepository.findByName(username);
  }

  @Override
  public Long returnEmail(String email) {
    return userRepository.findByEmail(email);
  }

  @Override
  public UserEntity refreshUser(String id) {
    UserEntity userToRefresh = userRepository.findById(UUID.fromString(id))
        .orElseThrow(() -> new RuntimeException("No se encontro el Usuario"));
    userToRefresh.setEndAccessDate(new Date().getTime() + 86400000);
    userRepository.save(userToRefresh);
    return userToRefresh;
  }

  @Override
  public void deleteAllUsers() {
    userRepository.deleteAll();
  }
}
