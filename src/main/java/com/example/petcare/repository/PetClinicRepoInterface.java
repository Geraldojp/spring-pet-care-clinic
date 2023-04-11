package com.example.petcare.repository;

import com.example.petcare.model.Pet;

import java.util.List;

public interface PetModelRepoInterface<T,M> {
    M create(M m);
    M update(M m, Long id);
    List<T> getAll();
    T getById(Long id);
    void delete(Long id);
}
