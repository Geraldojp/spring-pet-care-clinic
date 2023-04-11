package com.example.petcare.service;

import com.example.petcare.model.Owner;
import com.example.petcare.model.PetClinic;

import java.util.List;

public interface OwnerServiceInterface {
    Owner create (Owner owner);
    Owner update(Owner owner, Long id);
    List<Owner> getAll();
    Owner getById(Long id);
    void delete(Long id);

}
