package com.example.petcare.repository;

import com.example.petcare.model.PetClinic;

import java.util.List;

public interface PetClinicRepoInterface {
    PetClinic create(PetClinic petClinic) throws Exception;
    PetClinic update(PetClinic petClinic, Long id) throws Exception;
    List<PetClinic> getAll() throws Exception;
    PetClinic getById(Long id) throws Exception;
    void delete(Long id) throws Exception;
}
