package com.example.bdgesttest.persistence;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Contributor {

    // Attributs

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String role;

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

    @Override
    public String toString() {
        return "Contributor {\n" +
                "name = "+this.name+"\n" +
                "role = "+this.role+"\n" +
                "}\n";
    }

}
