package com.example.bdgesttest.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class User {

    // Attributs

    @Id
    @GeneratedValue
    private Long id;
    private String login;
    private String password;
    private String role;
    @OneToMany
    private List<Album> albumsList;

    // Constructeurs

    public User() {}

    public User(String login, String password, String role, List<Album> albumsList) {
        this.login = login;
        this.password = password;
        this.role = role;
        this.albumsList = albumsList;
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

    public List<Album> getAlbumsList() {
        return albumsList;
    }

    public void setAlbumsList(List<Album> albumsList) {
        this.albumsList = albumsList;
    }
}
