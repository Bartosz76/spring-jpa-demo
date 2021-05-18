package com.example.jpademo.repository;

import com.example.jpademo.models.Pokemon;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PokemonRepository extends CrudRepository<Pokemon, Long> {
    // CrudRepository gives me an entire arsenal for working with
    // Pokemon persistence, like saving, deleting and finding.

    // I can also define my own methods!
    List<Pokemon> findByName(String name);
    Pokemon findById(long id);
}
