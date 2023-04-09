package com.example.petcare.model.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PetDTO {
    private String name;
    private String type;
    private String breed;
    private String color;
    private String ownerName;
}
