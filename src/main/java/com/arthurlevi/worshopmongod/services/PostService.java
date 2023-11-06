package com.arthurlevi.worshopmongod.services;

import com.arthurlevi.worshopmongod.domain.Post;
import com.arthurlevi.worshopmongod.domain.User;
import com.arthurlevi.worshopmongod.repositories.PostRepository;
import com.arthurlevi.worshopmongod.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id){

        Post post = postRepository.findById(id).orElse(null);
        if(post == null){
            throw new ObjectNotFoundException("Object not found");
        }
        return post;
    }

    public List<Post> findByTitle(String text){
        return postRepository.findByTitleContainingIgnoreCase(text);
    }
}
