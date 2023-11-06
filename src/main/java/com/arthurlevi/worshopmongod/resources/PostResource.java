package com.arthurlevi.worshopmongod.resources;

import com.arthurlevi.worshopmongod.domain.Post;
import com.arthurlevi.worshopmongod.domain.User;
import com.arthurlevi.worshopmongod.dto.UserDTO;
import com.arthurlevi.worshopmongod.resources.util.URL;
import com.arthurlevi.worshopmongod.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService postService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post post = postService.findById(id);
        return ResponseEntity.ok().body(post);
    }

    @RequestMapping(value = "{titlesearch}", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text){
        text = URL.decodeParam(text);
        List<Post> postsDecode = postService.findByTitle(text);

        return ResponseEntity.ok().body(postsDecode);
    }
}
