package com.example.petcare.service;

import com.example.petcare.model.DTO.PetDTO;
import com.example.petcare.model.Pet;
import com.example.petcare.repository.PetModelRepoInterface;
import org.modelmapper.ModelMapper;

import java.util.List;

public class PetService  implements PetModelServiceInterface<Pet>{
    private PetModelRepoInterface<Pet> petRepo;
    private ModelMapper modelMapper;

    public PetService(PetModelRepoInterface<Pet> petRepo) {
        this.petRepo = petRepo;
    }

    @Override
    public Pet create(Pet pet) {
        return petRepo.create(pet);
    }

    @Override
    public Pet update(Pet pet, Long id) {
        return petRepo.update(pet, id);
    }

    @Override
    public List<Pet> getAll() {
        List<Pet> allPet =  petRepo.getAll();
        return allPet;
    }

    @Override
    public Pet getById(Long id) {
        return petRepo.getById(id);
    }

    @Override
    public void delete(Long id) {
        petRepo.delete(id);
    }
}
