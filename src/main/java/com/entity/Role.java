package com.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by user on 15.03.2016.
 */
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer id;

    @Column(name="role_name",nullable=false)
    private String roleName=RoleTypes.USER.getUserProfileType();

    public Role() {
    }

    public Role(String roleName) {
        this.roleName = roleName;
    }
    public Role(Integer id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getRoleName() {
        return roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}