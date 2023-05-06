package com.project.demo.controllers;


import com.project.demo.enums.Roles;
import com.project.demo.mappers.Select2Mapper;
import com.project.demo.mappers.UserEntityMapper;
import com.project.demo.models.dtomodels.Select2ModelDto;
import com.project.demo.models.dtomodels.UserEntityDto;
import com.project.demo.services.UserService;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserCrudControllerImpl implements UserCrudController {

  @Autowired
  private UserService userService;
  @Autowired
  private UserEntityMapper userEntityMapper;

  @Autowired
  private Select2Mapper select2Mapper;

  @Override
  public List<UserEntityDto> retrieveAllUsers() {

    return userEntityMapper.userEntityListToUserEntityDtoList(userService.retrieveAllUsers());
  }

  @Override
  public String retrieveUser(String username) {
    return userService.returnUser(username) >= 1L ? "false" : "true";
  }

  @Override
  public String retrieveEmail(String email) {
    return userService.returnEmail(email) >= 1L ? "false" : "true";
  }

  @Override
  public List<Select2ModelDto> retrieveAllRoles() {
    List<Select2ModelDto> select2ModelDtoList = new ArrayList<>();
    new Roles().retrieveAllRoles().entrySet()
        .forEach(entry -> select2ModelDtoList.add(select2Mapper.roleModelToSelect2ModelDto(entry)));
    return select2ModelDtoList;
  }

  @Override
  public String refreshUserGuest(String id) {
    return userEntityMapper.userEntityToUserEntityDto(userService.refreshUser(id))
        .getEndAccessDate();
  }

  @Override
  public UserEntityDto addNewUser(UserEntityDto newUserEntity) {
    return userEntityMapper.userEntityToUserEntityDto(
        userService.addNewUserEntity(userEntityMapper.userEntityDtoToUserEntity(newUserEntity)));
  }

  @Override
  public UserEntityDto updateUser(Long id, UserEntityDto newUserEntity) {
    return userEntityMapper.userEntityToUserEntityDto(
        userService.updateUserEntity(userEntityMapper.userEntityDtoToUserEntity(newUserEntity)));
  }
  
  @Override
  public void deleteUser(String id) {
    userService.deleteUser(id);
  }


  @Override
  public void deleteAllUsers() {
    /*
     * Solo el usuario administrador puede hacer el borrado de todos los usuario, menos el usuario admin.
     * */
    userService.deleteAllUsers();
  }
}
