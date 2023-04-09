package com.example.petcare.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class Owner {
    private Long ownerId;
    private String name;
    private String address;
    private String city;
    private String telephone;

    public Owner(String name, String address, String city, String telephone) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "ownerId=" + ownerId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
