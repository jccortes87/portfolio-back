package com.project.demo.mappers;

import com.project.demo.enums.Roles;
import com.project.demo.enums.Roles.Rol;
import com.project.demo.models.UserEntity;
import com.project.demo.models.dtomodels.UserEntityDto;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {

  @Mapping(source = "roles", target = "roles", qualifiedByName = "rolesToString")
  @Mapping(source = "endAccessDate", target = "endAccessDate", qualifiedByName = "timestampToDate")
  UserEntityDto userEntityToUserEntityDto(UserEntity userEntity);

  @Mapping(source = "roles", target = "roles", qualifiedByName = "stringToRoles")
  UserEntity userEntityDtoToUserEntity(UserEntityDto userEntityDto);

  List<UserEntityDto> userEntityListToUserEntityDtoList(List<UserEntity> userEntityList);

  List<UserEntity> userEntityDtoListToUserEntityList(List<UserEntityDto> userEntityDtoList);

  @Named("rolesToString")
  static String enumRolesToString(Rol role) {
    return role.toString();
  }

  @Named("stringToRoles")
  static Rol stringRolesToRoles(String role) {
    return Roles.Rol.valueOf(role);
  }

  @Named("timestampToDate")
  static String timestampToDate(Long timestamp) {
    if (timestamp == null) {
      return null;
    }
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Date date = new Date(timestamp);
    return dateFormat.format(date);
  }
}
