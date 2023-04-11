package com.example.petcare.repository;

import com.example.petcare.model.DTO.PetDTO;
import com.example.petcare.model.Pet;

import java.util.List;

public interface PetRepoInterface {
    Pet create(Pet pet);
    Pet update(Pet pet, Long id);
    List<PetDTO> getAll();
    PetDTO getById(Long id);
    void delete(Long id);
}
