package com.jeffsimonitto.spring.springbootplayground.repositories;

import com.jeffsimonitto.spring.springbootplayground.entities.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, String> {
}
