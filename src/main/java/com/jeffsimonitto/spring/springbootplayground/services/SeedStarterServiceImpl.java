package com.jeffsimonitto.spring.springbootplayground.services;

import com.jeffsimonitto.spring.springbootplayground.entities.SeedStarter;
import com.jeffsimonitto.spring.springbootplayground.repositories.SeedStarterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeedStarterServiceImpl implements SeedStarterService {
    @Autowired
    private SeedStarterRepository seedStarterRepository;

    public SeedStarterServiceImpl() {
        super();
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
