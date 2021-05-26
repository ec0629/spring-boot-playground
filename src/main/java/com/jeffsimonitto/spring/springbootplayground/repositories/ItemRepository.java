package com.jeffsimonitto.spring.springbootplayground.repositories;

import com.jeffsimonitto.spring.springbootplayground.entities.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface ItemRepository extends CrudRepository<Item, Integer>, QueryByExampleExecutor<Item> {
}
