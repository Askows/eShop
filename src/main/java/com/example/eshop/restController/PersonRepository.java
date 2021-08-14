package com.example.eshop.restController;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByName(String name);
    Optional<Person> findByAge(int age);
}
