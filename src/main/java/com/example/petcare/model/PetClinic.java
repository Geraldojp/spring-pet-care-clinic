package com.example.petcare.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PetClinic {
    private Long petClinicId;
    private String serviceName;
    private Long price;
    private String description;

    public PetClinic(String serviceName, Long price, String description) {
        this.serviceName = serviceName;
        this.price = price;
        this.description = description;
    }
}
