package com.pet.manager.repository;

import com.pet.manager.model.Love;
import com.pet.manager.model.Pet;
import com.pet.manager.model.PetType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PetRepository extends MongoRepository<Pet, String> {
    Optional<Pet> findPetByName(String name);
    List<Pet> findPetByPetType(PetType petType);
    @Query("{'pet.love': ?0}")
    List<Love> findByLove(final String love);
}