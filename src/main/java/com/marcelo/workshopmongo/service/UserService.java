package com.marcelo.workshopmongo.service;

import com.marcelo.workshopmongo.DTO.UserDTO;
import com.marcelo.workshopmongo.domain.User;
import com.marcelo.workshopmongo.repository.UserRepository;
import com.marcelo.workshopmongo.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User update(User obj) {
        User newObj = findById(obj.getId());
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    public void updateData(User newObj, User obj){
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    public User insert(User obj){
        return repository.insert(obj);
    }

    public void delete(String id){
        repository.deleteById(id);
    }

    public User fromDTO(UserDTO objDto){
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
}
