package com.example.petcare.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Pet {
    private Long petId;
    private String name;
    private String type;
    private String breed;
    private String color;
    private Long ownerId;

    public Pet(String name, String type, String breed, String color, Long ownerId) {
        this.name = name;
        this.type = type;
        this.breed = breed;
        this.color = color;
        this.ownerId = ownerId;
    }
}
