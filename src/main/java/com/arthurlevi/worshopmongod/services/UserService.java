package com.arthurlevi.worshopmongod.services;

import com.arthurlevi.worshopmongod.domain.User;
import com.arthurlevi.worshopmongod.dto.UserDTO;
import com.arthurlevi.worshopmongod.repositories.UserRepository;
import com.arthurlevi.worshopmongod.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){

        return userRepository.findAll();
    }

    public User findById(String id){

        User user = userRepository.findById(id).orElse(null);
        if(user == null){
            throw new ObjectNotFoundException("Object not found");
        }
        return user;
    }

    public User insert(User user){
        return userRepository.insert(user);
    }

    public User fromDTO(UserDTO userDTO){
        return new User(userDTO.getId(),userDTO.getName(),userDTO.getEmail());
    }
}
