package com.pet.manager.controller;
import com.pet.manager.controller.request.PetRequest;
import com.pet.manager.model.Pet;
import com.pet.manager.service.PetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@RestController
public class PetController {

    private PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping("/pet")
    public ResponseEntity<Pet> createPet(@RequestBody PetRequest petRequest){
        return ResponseEntity.ok(petService.createPet(petRequest));
    }

    @PutMapping("/pet-update/{id}")
    public ResponseEntity updatePetById(@PathVariable(value = "id") String petId, @RequestBody PetRequest petRequest){
        petService.updatedPetById(petId, petRequest);
        return ResponseEntity.created(URI.create("/pet/"+ petId)).body("Updated");
    }

    @GetMapping("/pet/{id}")
    public Pet getPetById(@PathVariable(value="id") String petId){
        return petService.getPetById(petId);
    }

    @GetMapping("/pet")
    public Pet getPetByName(@RequestParam String petName){
        return petService.getPetByName(petName);
    }


    @GetMapping("/pets")
    public List<Pet> getAllPets(){
        return petService.getPets();
    }

    @GetMapping("/pets/{type}")
    public List<Pet> getPetsByType(@PathVariable(value = "type") String type) {
        return petService.getPetsByType(type);
    }

    @DeleteMapping("/pet-delete/{id}")
    public ResponseEntity deletePetById(@PathVariable(value = "id")  String id){
        petService.deletePetById(id);
        return ResponseEntity.created(URI.create("/pet")).body("Deleted");
    }
}