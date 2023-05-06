package com.project.demo.controllers;

import com.project.demo.models.dtomodels.Select2ModelDto;
import com.project.demo.models.dtomodels.UserEntityDto;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project/users")
public interface UserCrudController {

  @CrossOrigin
  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  List<UserEntityDto> retrieveAllUsers();

  @CrossOrigin
  @GetMapping("/user")
  @ResponseStatus(HttpStatus.OK)
  String retrieveUser(@RequestParam(name = "username") String username);

  @CrossOrigin
  @GetMapping("/email")
  @ResponseStatus(HttpStatus.OK)
  String retrieveEmail(@RequestParam(name = "email") String email);


  @CrossOrigin
  @GetMapping("/roles")
  @ResponseStatus(HttpStatus.OK)
  List<Select2ModelDto> retrieveAllRoles();

  @CrossOrigin
  @PutMapping("/refresh")
  @ResponseStatus(HttpStatus.OK)
  String refreshUserGuest(@RequestParam(name = "id") String id);

  @CrossOrigin
  @PostMapping
  @ResponseStatus(HttpStatus.OK)
  UserEntityDto addNewUser(@RequestBody UserEntityDto newUserEntity);

  @CrossOrigin
  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  UserEntityDto updateUser(@RequestParam Long id, @RequestBody UserEntityDto newUserEntity);

  @CrossOrigin
  @DeleteMapping
  @ResponseStatus(HttpStatus.OK)
  void deleteUser(@RequestParam(name = "id") String id);

  @CrossOrigin
  @DeleteMapping("/deleteAll")
    /*Solo el usuario administrador puede hacer la llamada a este controlador*/
  void deleteAllUsers();


}
