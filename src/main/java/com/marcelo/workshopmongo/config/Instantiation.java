package com.marcelo.workshopmongo.config;

import com.marcelo.workshopmongo.DTO.AuthorDTO;
import com.marcelo.workshopmongo.domain.Post;
import com.marcelo.workshopmongo.domain.User;
import com.marcelo.workshopmongo.repository.PostRepository;
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

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User marcos = new User(null, "Marcos Baggio", "marcosbaggio@hotmail.com");
        User savio = new User(null, "Savio Lewandowisk", "saviolewandowiks@gmail.com");
        User maria = new User(null, "Maria Brown", "maria@gmail.com");

        userRepository.saveAll(Arrays.asList(marcos, savio, maria));

        Post post1 = new Post(null, sdf.parse("21/03/2026"), "Partiu viagem", "Vou viajar para Sao Paulo. Abracos!", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("02/04/2026"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);
    }
}