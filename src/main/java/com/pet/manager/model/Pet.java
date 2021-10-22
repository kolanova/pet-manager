package com.pet.manager.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class Pet {
    @Id
    private String id;
    private int age;
    @Indexed(unique = true)
    private String name;
    @Indexed(unique = false)
    private PetType petType;
    private List<Love> love;
}