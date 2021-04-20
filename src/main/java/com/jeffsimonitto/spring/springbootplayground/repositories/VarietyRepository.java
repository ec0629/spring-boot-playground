package com.jeffsimonitto.spring.springbootplayground.repositories;

import com.jeffsimonitto.spring.springbootplayground.entities.Variety;

import java.util.List;

public interface VarietyRepository {
    List<Variety> findAll();
    Variety findById(int id);
}
