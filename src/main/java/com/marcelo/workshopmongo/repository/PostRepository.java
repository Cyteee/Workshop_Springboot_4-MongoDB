package com.marcelo.workshopmongo.repository;

import com.marcelo.workshopmongo.domain.Post;
import com.marcelo.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
