package com.jeffsimonitto.spring.springbootplayground.entities;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "seed_starter_row")
public class Row {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @ManyToOne
    @Valid
    private Variety variety = null;
    @Min(value = 1, message = "Seeds per cell must be greater than 0.")
    @NotNull
    private Integer seedsPerCell = null;

    public Row() {
    }

    public int getId() { return Id; }

    public void setId(int id) { Id = id; }

    public Variety getVariety() { return variety; }

    public void setVariety(final Variety variety) { this.variety = variety; }

    public Integer getSeedsPerCell() { return seedsPerCell; }

    public void setSeedsPerCell(final Integer seedsPerCell) { this.seedsPerCell = seedsPerCell; }
}
