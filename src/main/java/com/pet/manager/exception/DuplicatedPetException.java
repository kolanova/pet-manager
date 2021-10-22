package com.pet.manager.exception;

public class DuplicatedPetException extends RuntimeException{
    public DuplicatedPetException(){
        super("Pet with this name already exists");
    }
    public DuplicatedPetException(String message){super(message);}
}
