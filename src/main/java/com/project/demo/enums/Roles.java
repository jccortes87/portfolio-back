package com.project.demo.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Roles {

    public enum Rol{
        ADMINISTRATOR,GUEST,USER_VIEW
    }

    public Map<Integer,String> retrieveAllRoles(){
      return  Arrays.stream(Rol.values()).collect(Collectors.toMap(Rol::ordinal,Rol::name));
    }



}
