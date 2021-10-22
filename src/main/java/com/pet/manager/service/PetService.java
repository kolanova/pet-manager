package com.pet.manager.service;

import com.pet.manager.controller.request.PetRequest;
import com.pet.manager.exception.DuplicatePetException;
import com.pet.manager.exception.ResourceNotFound;
import com.pet.manager.model.Pet;
import com.pet.manager.model.PetType;
import com.pet.manager.repository.PetRepository;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class PetService {

    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public List<Pet> getPets() {
        return petRepository.findAll();
    }

    @Transactional
    public Pet createPet(PetRequest petRequest) {
        try {
            return petRepository.insert(
                    Pet
                            .builder()
                            .name(petRequest.getName())
                            .love(petRequest.getLove())
                            .build());
        } catch (DuplicateKeyException exception) {
            throw new DuplicatePetException();
        }
    }


    public Pet getPetById(String petid) {
        try {
            return petRepository.findById(petid).get();
        } catch (ResourceNotFound exception) {
            throw new ResourceNotFound("Pet not found");
        }
    }

    @Transactional
    public void deletePetById(String id) {
        try {
            petRepository.deleteById(id);
        } catch (ResourceNotFound exception) {
            throw new ResourceNotFound("No pet");
        }
    }

    public Pet getPetByName(String petName) {
        try {
            return petRepository.findPetByName(petName).get();
        } catch (ResourceNotFound exception) {
            throw new ResourceNotFound("Pet not found");
        }
    }

    @Transactional
    public Pet updatedPetById(String petId, PetRequest petRequest) {
        try {
            petRepository.findById(petId);
        } catch (ResourceNotFound exception) {
            throw new ResourceNotFound("Pet not found");
        }
        int age = petRequest.getAge();
        String name = petRequest.getName();
        if(petRepository.findPetByName(name).isPresent()){
            throw new DuplicatePetException("Choose a different name");
        }
        PetType petType = PetType.valueOf(petRequest.getPetType());
        Pet pet = petRepository.findById(petId).get();
        pet.setName(name);
        pet.setLove(petRequest.getLove());
        pet.setPetType(petType);
        pet.setAge(age);
        return petRepository.save(pet);
    }

    public List<Pet> getPetsByType(String type) {
        List<String> listTypes = new ArrayList<String>();
        listTypes.add(PetType.CAT.toString());
        listTypes.add(PetType.DOG.toString());
        listTypes.add(PetType.EAGLE.toString());
        if(!listTypes.contains(type)){
            throw new ResourceNotFound("you need to create CAT, DOG or EAGLE");
        }
        return petRepository.findPetByPetType(PetType.valueOf(type));
    }
}