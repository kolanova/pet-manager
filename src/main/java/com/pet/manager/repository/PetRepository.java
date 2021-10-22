package com.pet.manager.repository;

import com.pet.manager.model.Pet;
import com.pet.manager.model.PetType;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PetRepository extends MongoRepository<Pet, String> {
}