package com.arthurlevi.worshopmongod.services;

import com.arthurlevi.worshopmongod.domain.User;
import com.arthurlevi.worshopmongod.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> finAll(){

        return userRepository.findAll();
    }
}
