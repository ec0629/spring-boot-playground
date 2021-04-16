package com.jeffsimonitto.spring.springbootplayground.services;

import com.jeffsimonitto.spring.springbootplayground.entities.SeedStarter;
import com.jeffsimonitto.spring.springbootplayground.repositories.SeedStarterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeedStarterServiceImpl implements SeedStarterService {
    private final SeedStarterRepository seedStarterRepository;

    public SeedStarterServiceImpl(SeedStarterRepository seedStarterRepository) {
        this.seedStarterRepository = seedStarterRepository;
    }

    @Override
    public List<SeedStarter> findAll() {
        return this.seedStarterRepository.findAll();
    }

    @Override
    public void add(final SeedStarter seedStarter) {
        this.seedStarterRepository.add(seedStarter);
    }
}
