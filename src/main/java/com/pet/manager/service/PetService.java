package com.pet.manager.service;

import com.pet.manager.controller.CreatePetRQ;
import com.pet.manager.exception.ResourceNotFound;
import com.pet.manager.model.Pet;
import com.pet.manager.model.PetType;
import com.pet.manager.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }
    public List<Pet> findAll() {
        return petRepository.findAll();
    }
    public Optional<Pet> findById(String id) {
        return petRepository.findById(id);
    }
    public Pet findById(String id){
    return petRepository.findById(id).orElseThrow(()-> new ResourceNotFound("Pet doesn't exist"));
    }
    public Pet create(CreatePetRQ createPetRQ) {
        List<String> lisTypes = new ArrayList<>();
        lisTypes.add(PetType.CAT.toString());
        lisTypes.add(PetType.DOG.toString());
        lisTypes.add(PetType.EAGLE.toString());
        if (!lisTypes.contains(createPetRQ.getPetType().toString())){
            throw new ResourceNotFound("You can only add a certain name of pets in the list");
        }
        PetType petType = createPetRQ.getPetType();
        String petName = createPetRQ.getName();
        Pet newPet = Pet
                .builder()
                .name(petName)
                .petType(petType)
                .build();
        return petRepository.save(newPet);
    }
}
