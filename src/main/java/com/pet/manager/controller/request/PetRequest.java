package com.pet.manager.controller.request;

import com.pet.manager.model.Love;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PetRequest {
    private String name;
    private int age;
    private String petType;
    private List<Love> love;
}
