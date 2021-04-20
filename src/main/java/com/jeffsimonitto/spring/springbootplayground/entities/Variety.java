package com.jeffsimonitto.spring.springbootplayground.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Variety {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    private String name = null;

    public Variety() {
    }

    public int getId() { return this.id; }

    public void setId(final int id) { this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
