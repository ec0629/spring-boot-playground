package com.jeffsimonitto.spring.springbootplayground.components;

import com.jeffsimonitto.spring.springbootplayground.entities.Item;
import com.jeffsimonitto.spring.springbootplayground.repositories.ItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RepositoryDatabaseLoader {

    @Bean
    CommandLineRunner initialize(ItemRepository repository) {
        return args -> {
            repository.save(new Item("Alf alarm clock", "kids clock", 19.99));
            repository.save(new Item("Smurf TV tray", "kids TV tray", 24.99));
        };
    }
}
