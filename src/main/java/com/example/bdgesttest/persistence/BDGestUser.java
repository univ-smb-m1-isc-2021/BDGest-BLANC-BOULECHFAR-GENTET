package com.example.bdgesttest.persistence;

import javax.persistence.*;

@Entity
public class BDGestUser {

    // Attributs
    @Id
    @GeneratedValue
    private long id;
    private String login;
    private String password;
    private String role;

    // Constructeurs
    public BDGestUser() {}

    public BDGestUser(String login, String password, String role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    // Méthodes
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
