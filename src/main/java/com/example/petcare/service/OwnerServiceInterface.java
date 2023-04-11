package com.example.petcare.service;

import com.example.petcare.model.PetClinic;

import java.util.List;

public interface PetClinicServiceInterface {
    PetClinic create (PetClinic petClinic);
    PetClinic update(PetClinic petClinic, Long id);
    List<PetClinic> getAll();
    PetClinic getById(Long id);
    void delete(Long id);

}
