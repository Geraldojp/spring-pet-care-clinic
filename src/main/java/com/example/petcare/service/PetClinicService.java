package com.example.petcare.service;

import com.example.petcare.model.Pet;
import com.example.petcare.model.PetClinic;
import com.example.petcare.repository.PetClinicRepoInterface;


import java.util.List;

public class PetClinicService implements PetClinicServiceInterface {
    private PetClinicRepoInterface petClinicRepo;

    public PetClinicService(PetClinicRepoInterface petClinicRepo) {
        this.petClinicRepo = petClinicRepo;
    }

    @Override
    public PetClinic create(PetClinic petClinic) {
        try {
            if (petClinic.getServiceName() == null || petClinic.getServiceName().isEmpty())
                System.out.println("Name is required");
            if (petClinic.getDescription() == null || petClinic.getDescription().isEmpty())
                System.out.println("Description is required");
            if (petClinic.getPrice() == null || petClinic.getPrice().describeConstable().isEmpty())
                System.out.println("Price is required");
            return petClinicRepo.create(petClinic);
        }catch (Exception e){
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public PetClinic update(PetClinic petClinic, Long id) {
        try {
            PetClinic petClinicCheck = petClinicRepo.getById(id);
            if (petClinic.equals(petClinicCheck)) {
                System.out.println("Already Exists");
            }
            return petClinicRepo.update(petClinic, id);
        }catch (Exception e){
            throw new IllegalArgumentException(e);
        }
    }
    @Override
    public List<PetClinic> getAll() {
        try {
            List<PetClinic> allPetClinic = petClinicRepo.getAll();
            if (allPetClinic.isEmpty())
                System.out.println("Database is empty");
            return allPetClinic;
        }catch (Exception e){
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public PetClinic getById(Long id) {
        try {
            PetClinic petClinic = petClinicRepo.getById(id);
            if (petClinic == null)
                System.out.println("Service not found");
            return petClinic;
        }catch (Exception e){
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public void delete(Long id) {
        try {
            PetClinic petClinic = petClinicRepo.getById(id);
            if (petClinic == null)
                System.out.println("Service not found");
            petClinicRepo.delete(id);
        }catch (Exception e){
            throw new IllegalArgumentException(e);
        }
    }
}
