package com.example.petcare.service;

import com.example.petcare.model.DTO.PetDTO;
import com.example.petcare.model.PetClinic;
import com.example.petcare.repository.PetModelRepoInterface;

import java.util.List;

public class PetClinicService implements PetModelServiceInterface<PetClinic> {
    private PetModelRepoInterface<PetClinic> petClinicRepo;

    public PetClinicService(PetModelRepoInterface<PetClinic> petClinicRepo) {
        this.petClinicRepo = petClinicRepo;
    }

    @Override
    public PetClinic create(PetClinic petClinic) {
        return petClinicRepo.create(petClinic);
    }

    @Override
    public PetClinic update(PetClinic petClinic, Long id) {
        return petClinicRepo.update(petClinic, id);
    }
    @Override
    public List<PetClinic> getAll() {
        return petClinicRepo.getAll();
    }

    @Override
    public PetClinic getById(Long id) {
        return petClinicRepo.getById(id);
    }

    @Override
    public void delete(Long id) {
        petClinicRepo.delete(id);
    }
}
