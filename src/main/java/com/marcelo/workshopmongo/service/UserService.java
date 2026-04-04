package com.marcelo.workshopmongo.service;

import com.marcelo.workshopmongo.domain.User;
import com.marcelo.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }
}
