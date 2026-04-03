package com.marcelo.workshopmongo.resources;

import com.marcelo.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll(){
        User joao = new User("1", "Joao Bernardo", "joaobernardo@gmail.com");
        User marcelo = new User("2", "Marcelo Sousa", "marcelosousa@hotmail.com");

        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(joao, marcelo));
        return ResponseEntity.ok().body(list);
    }
}
