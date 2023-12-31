package com.arthurlevi.worshopmongod.config;

import com.arthurlevi.worshopmongod.domain.Post;
import com.arthurlevi.worshopmongod.domain.User;
import com.arthurlevi.worshopmongod.dto.AuthorDTO;
import com.arthurlevi.worshopmongod.dto.CommentDTO;
import com.arthurlevi.worshopmongod.repositories.PostRepository;
import com.arthurlevi.worshopmongod.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Intantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria,alex,bob));

        AuthorDTO authorMaria = new AuthorDTO(maria);
        AuthorDTO authorAlex = new AuthorDTO(alex);
        AuthorDTO authorBob = new AuthorDTO(bob);





        Post post1 = new Post(null,sdf.parse("21/03/2018"),"Partiu viajar","Indo para Russas.A braços!!!",authorMaria);
        Post post2 = new Post(null,sdf.parse("01/06/2018"),"Bom dai a todos!!!","Hoje é um dia feliz!!!",authorMaria);

        CommentDTO comment1 = new CommentDTO("Boa viagem",sdf.parse("22/03/2018"),authorAlex);
        CommentDTO comment2 = new CommentDTO("Otima viagem",sdf.parse("21/03/2018"),authorBob);

        post1.getComments().addAll(Arrays.asList(comment1,comment2));
        postRepository.saveAll(Arrays.asList(post1,post2));

        maria.getPosts().addAll(Arrays.asList(post1,post2));
        userRepository.save(maria);
    }
}
