package com.pet.manager.controller.response;

import com.pet.manager.model.PetType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PetResponse {
    private String name;
    private int age;
    private PetType petType;
}
