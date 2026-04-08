package com.marcelo.workshopmongo.service;

import com.marcelo.workshopmongo.domain.Post;
import com.marcelo.workshopmongo.repository.PostRepository;
import com.marcelo.workshopmongo.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        Optional<Post> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
}