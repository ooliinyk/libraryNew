package com.entity;

/**
 * Created by user on 17.03.2016.
 */
public enum RoleTypes {
    USER("USER"),
    DBA("DBA"),
    ADMIN("ADMIN"),
    ANONYM("ANONYM");

    String roleType;

    private RoleTypes(String roleType){
        this.roleType = roleType;
    }

    public String getUserProfileType(){
        return roleType;
    }
}
