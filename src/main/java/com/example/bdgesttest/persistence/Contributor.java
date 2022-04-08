package com.example.bdgesttest.persistence;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Contributor {
    String name, role;
    private Long id;

    public Contributor(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public Contributor() {

    }

    @Override
    public String toString() {
        return "Contributor{" +
                "name='" + name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
