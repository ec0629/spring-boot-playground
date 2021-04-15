package com.jeffsimonitto.spring.springbootplayground.services;

import com.jeffsimonitto.spring.springbootplayground.entities.SeedStarter;

import java.util.List;

public interface SeedStarterService {
    List<SeedStarter> findAll();
    void add(SeedStarter seedStarter);
}
