package com.jeffsimonitto.spring.springbootplayground.repositories;

import com.jeffsimonitto.spring.springbootplayground.entities.SeedStarter;

import java.util.List;

public interface SeedStarterRepository {
    List<SeedStarter> findAll();
    void add(final SeedStarter seedStarter);
}
