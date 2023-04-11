package com.example.petcare.service;

import com.example.petcare.model.DTO.PetDTO;
import com.example.petcare.model.Pet;
import com.example.petcare.repository.PetRepoInterface;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataAccessException;

import java.util.List;

public class PetService implements PetServiceInterface {
    private PetRepoInterface petRepo;
    private ModelMapper modelMapper;

    public PetService(PetRepoInterface petRepo) {
        this.petRepo = petRepo;
    }

    @Override
    public Pet create(Pet pet) {
        try {
            return petRepo.create(pet);
        }catch (Exception e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @Override
    public Pet update(Pet pet, Long id) {
        try {
            return petRepo.update(pet, id);
        }catch (Exception e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @Override
    public List<PetDTO> getAll() {
        try {
            List<PetDTO> allPetDTO = petRepo.getAll();
            return allPetDTO;
        }catch (Exception e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @Override
    public PetDTO getById(Long id) {
        try {
            PetDTO pet = petRepo.getById(id);
            return petRepo.getById(id);
        }catch (Exception e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @Override
    public void delete(Long id) {
        try {
            PetDTO pet = petRepo.getById(id);
            petRepo.delete(id);
        }catch (Exception e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

}
