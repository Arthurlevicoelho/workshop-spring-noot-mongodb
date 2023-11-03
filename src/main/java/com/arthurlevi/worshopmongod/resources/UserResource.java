package com.arthurlevi.worshopmongod.resources;

import com.arthurlevi.worshopmongod.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        User user1 = new User("1","Maria","maria@gmail.com");
        User user2 = new User("2","Marcos","marcos@gmail.com");
        return ResponseEntity.ok().body(new ArrayList<>(Arrays.asList(user1, user2)));

    }
}
