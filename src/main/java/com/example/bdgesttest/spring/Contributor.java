package com.example.bdgesttest.spring;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;

@Entity
public class Contributor extends AbstractPersistable<Long> {

    // Attributs

    private String name;
    private String role;

    // Constructeurs

    public Contributor() {}

    public Contributor(Long id_contributor) {
        this.setId(id_contributor);
    }

    public Contributor(String name, String role) {
        this.name = name;
        this.role = role;
    }

    // Methodes

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
                "}";
    }

}
