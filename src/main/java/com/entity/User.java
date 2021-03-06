package com.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by user on 15.03.2016.
 */

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;

    @NotEmpty
    @Column(name = "user_login", unique = true)
    private String login;

    @NotEmpty
    @Column(name = "user_password")
    private String password;

    @NotEmpty
    @Column(name = "user_name")
    private String name;


    @NotEmpty
    @Column(name = "user_lastname")
    private String lastName;

    @NotEmpty
    @Email
    @Column(name = "user_email")
    private String email;

//    @NotEmpty
    @Column(name = "user_phone_number")
    private int phone;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_user",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<Role> roles = new HashSet<Role>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "book_lists",
            joinColumns = {@JoinColumn(name = "user_idd")},
            inverseJoinColumns = {@JoinColumn(name = "book_idd")})
    private Set<Book> books = new HashSet<Book>();

    public User() {
    }

    public User(String login, String password, String name, String lastName, String email, int phone, Set<Role> roles, Set<Book> books) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.roles = roles;
        this.books = books;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
