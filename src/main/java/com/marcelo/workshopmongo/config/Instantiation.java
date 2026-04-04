package com.marcelo.workshopmongo.config;

import com.marcelo.workshopmongo.domain.User;
import com.marcelo.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll(); // Limpa o banco

        User marcos = new User(null, "Marcos Baggio", "marcosbaggio@hotmail.com");
        User savio = new User(null, "Savio Lewandowisk", "saviolewandowiks@gmail.com");

        userRepository.saveAll(Arrays.asList(marcos, savio)); // Salva os caras de novo!
    }
}