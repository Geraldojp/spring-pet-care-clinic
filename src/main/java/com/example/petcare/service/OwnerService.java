package com.example.petcare.service;

import com.example.petcare.model.DTO.PetDTO;
import com.example.petcare.model.Owner;

import com.example.petcare.repository.PetModelRepoInterface;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public class OwnerService implements PetModelServiceInterface<Owner> {
    private PetModelRepoInterface<Owner> ownerRepo;

    public OwnerService(PetModelRepoInterface<Owner> ownerRepo) {
        this.ownerRepo = ownerRepo;
    }

    @Override
    public Owner create(Owner owner) {
        return ownerRepo.create(owner);
    }

    @Override
    public Owner update(Owner owner, Long id) {
        return ownerRepo.update(owner, id);
    }

    @Override
    public List<Owner> getAll() {
        return ownerRepo.getAll();
    }

    @Override
    public Owner getById(Long id) {
        return ownerRepo.getById(id);
    }

    @Override
    public void delete(Long id) {
        ownerRepo.delete(id);
    }
}
