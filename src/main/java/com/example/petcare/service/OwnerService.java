package com.example.petcare.service;

import com.example.petcare.model.Owner;

import com.example.petcare.repository.OwnerRepoInterface;

import java.lang.Exception;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class OwnerService implements OwnerServiceInterface {
    private OwnerRepoInterface ownerRepo;

    public OwnerService(OwnerRepoInterface ownerRepo) {
        this.ownerRepo = ownerRepo;
    }

    @Override
    public Owner create(Owner owner) {
        try {
            return ownerRepo.create(owner);
        } catch (Exception e) {
            System.out.println("Error create owner");
            return null;
        }
    }

    @Override
    public Owner update(Owner owner, Long id) {
        try {
            return ownerRepo.update(owner, id);
        } catch (Exception e) {
            System.out.println("Error update owner");
            return null;
        }
    }

    @Override
    public List<Owner> getAll() {
        try {
            return ownerRepo.getAll();
        } catch (Exception e) {
            System.out.println("Error get all owner");
            return null;
        }
    }

    @Override
    public Owner getById(Long id) {
        while (true){
            try {
                Owner owner = ownerRepo.getById(id);
                return owner;
            } catch (Exception e) {
                System.out.println("Error get owner by id");
                return null;

            }
        }
    }

    @Override
    public void delete(Long id) {
        try {
            ownerRepo.delete(id);
        } catch (Exception e) {
            System.out.println("Error delete owner");
        }
    }
}
