package com.arthurlevi.worshopmongod.dto;

import com.arthurlevi.worshopmongod.domain.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.annotation.Id;

public class AuthorDTO {

    @Id
    private String id;
    private String name;

    public AuthorDTO(){}

    public AuthorDTO(User user) {
      this.id = user.getId();
      this.name = user.getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
