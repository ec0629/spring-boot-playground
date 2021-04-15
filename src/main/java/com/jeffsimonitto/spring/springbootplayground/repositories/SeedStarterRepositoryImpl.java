package com.jeffsimonitto.spring.springbootplayground.repositories;

import com.jeffsimonitto.spring.springbootplayground.entities.SeedStarter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SeedStarterRepositoryImpl implements SeedStarterRepository{
    private final List<SeedStarter> seedStarters = new ArrayList<>();

    public SeedStarterRepositoryImpl() {
        super();
    }

    @Override
    public List<SeedStarter> findAll() {
        return new ArrayList<>(this.seedStarters);
    }

    @Override
    public void add(final SeedStarter seedStarter) {
        this.seedStarters.add(seedStarter);
    }
}
