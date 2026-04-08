package com.marcelo.workshopmongo.config;

import com.marcelo.workshopmongo.domain.Post;
import com.marcelo.workshopmongo.domain.User;
import com.marcelo.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();

        User marcos = new User(null, "Marcos Baggio", "marcosbaggio@hotmail.com");
        User savio = new User(null, "Savio Lewandowisk", "saviolewandowiks@gmail.com");

        Post post1 = new Post(null, sdf.parse("21/03/2026"), "Partiu viagem", "Vou viajar para Sao Paulo. Abracos!");
        Post post2 = new Post(null, sdf.parse("02/04/2026"), "Bom dia", "Acordei feliz hoje!");

        userRepository.saveAll(Arrays.asList(marcos, savio));
    }
}