package com.jeffsimonitto.spring.springbootplayground.services;

import com.jeffsimonitto.spring.springbootplayground.entities.Variety;

import java.util.List;

public interface VarietyService {
    List<Variety> findAll();
    Variety findById(Integer id);
}
