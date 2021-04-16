package com.jeffsimonitto.spring.springbootplayground.services;

import com.jeffsimonitto.spring.springbootplayground.entities.Variety;
import com.jeffsimonitto.spring.springbootplayground.repositories.VarietyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VarietyServiceImpl implements VarietyService {
    private final VarietyRepository varietyRepository;

    public VarietyServiceImpl(VarietyRepository varietyRepository) {
        this.varietyRepository = varietyRepository;
    }

    @Override
    public List<Variety> findAll() {
        return this.varietyRepository.findAll();
    }

    @Override
    public Variety findById(final Integer id) {
        return this.varietyRepository.findById(id);
    }
}
