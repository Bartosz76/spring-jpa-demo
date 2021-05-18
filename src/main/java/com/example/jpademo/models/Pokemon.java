package com.example.jpademo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // No @Table means it's assumed the table matches the name of the class.
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // As the name suggests. I don't need to do it myself.
    private Long id;
    // It's assumed below ones have their respective equivalents in the DB.
    private String name;
    private String type;

    // The default constructor exists for the sake of JPA alone. It won't be
    // used directly, hence - protected.
    protected Pokemon() {

    }

    // This one will be used to create instances of Pokemon to be saved
    // into a DB.
    public Pokemon(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format(
                "Pokemon[id=%d, name='%s', type='%s']",
                id, name, type);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
