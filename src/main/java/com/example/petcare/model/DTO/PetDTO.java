package com.example.petcare.model.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class PetDTO {
    private String name;
    private String type;
    private String breed;
    private String color;
    private String ownerName;

    @Override
    public String toString() {
        return '|'+"name:'" + name + '\'' + '|'+
                " type:'" + type + '\'' +'|'+
                " breed:'" + breed + '\'' +'|'+
                " color:'" + color + '\'' +'|'+
                " ownerName:'" + ownerName + '\''+'|';
    }
}
