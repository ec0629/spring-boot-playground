package com.jeffsimonitto.spring.springbootplayground.entities;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class SeedStarter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull(message = "Date planted is required")
    private Date datePlanted = null;
    private Boolean covered = null;
    @Enumerated(EnumType.STRING)
    private Type type = Type.PLASTIC;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<Feature> features = null;
    @OneToMany
    // by including @JoinColumn we override the default join table implementation
    @JoinColumn(name = "seed_starter_id")
    @Valid
    private List<Row> rows = new ArrayList<>();

    public SeedStarter() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public Date getDatePlanted() {
        return datePlanted;
    }

    public void setDatePlanted(final Date datePlanted) {
        this.datePlanted = datePlanted;
    }

    public Boolean getCovered() {
        return covered;
    }

    public void setCovered(final Boolean covered) {
        this.covered = covered;
    }

    public Type getType() {
        return type;
    }

    public void setType(final Type type) {
        this.type = type;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(final List<Feature> features) {
        this.features = features;
    }

    public List<Row> getRows() {
        return rows;
    }
}
