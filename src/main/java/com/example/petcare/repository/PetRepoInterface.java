package com.example.petcare.repository;

import com.example.petcare.model.DTO.PetDTO;
import com.example.petcare.model.Pet;

import java.util.List;

public interface PetRepoInterface {
    Pet create(Pet pet) throws Exception;
    Pet update(Pet pet, Long id) throws Exception;
    List<PetDTO> getAll() throws Exception;
    PetDTO getById(Long id) throws Exception;
    void delete(Long id) throws Exception;
}
