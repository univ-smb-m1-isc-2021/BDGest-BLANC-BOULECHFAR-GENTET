package com.example.bdgesttest.persistence;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class BDGestUser {

    // Attributs
    @Id
    @Column(name="id_user", nullable = false, updatable = false)
    @GeneratedValue
    private long id;
    private String login;
    private String password;
    private String role;

    @JsonManagedReference
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "userAlbum",
            joinColumns = { @JoinColumn(name = "id_user") },
            inverseJoinColumns = { @JoinColumn(name = "id_album") })
    private Set<Album> userAlbum = new HashSet<>();

    // Constructeurs
    public BDGestUser() {}

    public BDGestUser(Long id){
        this.id = id;
    }

    public BDGestUser(String login, String password, String role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public BDGestUser(String login, String password, String role, Set<Album> contributorSet) {
        this.login = login;
        this.password = password;
        this.role = role;
        this.userAlbum = contributorSet;
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

    public void setId(long id) {
        this.id = id;
    }

    @JsonManagedReference
    public Set<Album> getUserAlbum() {
        return userAlbum;
    }

    public void setUserAlbum(Set<Album> userAlbum) {
        this.userAlbum = userAlbum;
    }
}
