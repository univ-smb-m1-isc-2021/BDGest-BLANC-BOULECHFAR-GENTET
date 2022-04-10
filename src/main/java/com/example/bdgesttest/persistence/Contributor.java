package com.example.bdgesttest.persistence;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "contributor")
public class Contributor {

    // Attributs
    @Id
    @Column(name="id_contributor", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String role;

    @JsonBackReference
    @ManyToMany(mappedBy = "contributorAlbum", cascade = CascadeType.MERGE)
    private Set<Album> contributorAlbum = new HashSet<>();

    // Constructeurs
    public Contributor() {}

    public Contributor(String name, String role) {
        this.name = name;
        this.role = role;
    }

    // Methodes
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @JsonBackReference
    public Set<Album> getContributors() {
        return contributorAlbum;
    }

    public void setContributors(Set<Album> contributors) {
        this.contributorAlbum = contributors;
    }

    @Override
    public String toString() {
        return "Contributor {\n" +
                "name = "+this.name+"\n" +
                "role = "+this.role+"\n" +
                "}\n";
    }

}
