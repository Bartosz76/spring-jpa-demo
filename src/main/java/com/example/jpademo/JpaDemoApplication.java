package com.example.jpademo;

import com.example.jpademo.models.Pokemon;
import com.example.jpademo.repository.PokemonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaDemoApplication {

    /**
     * @SpringBootApplication basically is @Configuration, @EnableAutoConfiguration,
     * @ComponentScan combined.
     * @Configuration -> tags the class as a source of bean definitions for the
     * application context (the SpringApplication up there).
     * @EnableAutoConfiguration -> asks SpringBoot to start adding beans based on
     * classpath settings, other beans and various property settings.
     * @ComponentScan -> asks Spring to search for happiness as well as other
     * components, configurations and services in the package... letting it find
     * the controllers.
     */

    public static void main(String[] args) {
        SpringApplication.run(JpaDemoApplication.class, args);
    }

    private static final Logger logger = LoggerFactory.getLogger(JpaDemoApplication.class);

    // The below CommandLineRunner bean runs automatically when the application
    // is launched.
    @Bean
    public CommandLineRunner demo(PokemonRepository repository) {
        return args -> {
            // Saving a few records.
            repository.save(new Pokemon("Pikachu", "Electric"));
            repository.save(new Pokemon("Charmander", "Fire"));
            repository.save(new Pokemon("Drednaw", "Water"));
            repository.save(new Pokemon("Blaziken", "Fire"));

            // Fetching all saved Pokemon!
            logger.info("All the pokemon found with .findAll():");
            printADividingLine();
            for (Pokemon pokemon : repository.findAll()) {
                logger.info(pokemon.toString());
            }
            logger.info("");

            // Fetching an individual Pokemon by its ID!
            Pokemon pokemon = repository.findById(3L);
            logger.info("A pokemon found with .findById(3L):");
            printADividingLine();
            logger.info(pokemon.toString());
            logger.info("");

            // Fetching an individual Pokemon by its name!
            logger.info("A pokemon found with .findByName('Charmander'):");
            printADividingLine();
            repository.findByName("Charmander").forEach(foundPokemon -> {
                logger.info(foundPokemon.toString());
            });
            // The above method is basically:
            // for (Pokemon foundPokemon : repository.findByName("Charmander")) {
            // logger.info(foundPokemon.toString());
            // }
            logger.info("");
        };
    }

    private void printADividingLine() {
        logger.info("-----------------------------");
    }


}
