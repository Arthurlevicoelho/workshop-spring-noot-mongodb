package com.arthurlevi.worshopmongod.repositories;

import com.arthurlevi.worshopmongod.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
}
