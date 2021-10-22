package com.pet.manager.controller;

import com.pet.manager.model.Pet;
import com.pet.manager.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class PetController {

    private final PetService petService;
    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping(value ="/pets", consumes = "application/json", produces = "application/json")
    public void createPet(@RequestBody CreatePetRQ createPetRQ){
        String petName = petService.create(createPetRQ).getName();
        return ResponseEntity.created(URI.create("/pet" + petName)).body("Pet was added to our DB");
    }
    @GetMapping("/pets{id}")
    public List<Pet> getPets(){
        public Optional<Pet> getPetsId(String id){
            return petService.findById(id);}

    }



}
