package com.jeffsimonitto.spring.springbootplayground.entities;

public class Variety {
    private Integer id = null;
    private String name = null;

    public Variety() {
        super();
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
