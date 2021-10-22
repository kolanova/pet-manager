package com.pet.manager.repository;

import com.pet.manager.model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AuthorRepository extends MongoRepository<Author, String> {
    Optional<Author> findAuthorByFirstName(String firstName);
}
