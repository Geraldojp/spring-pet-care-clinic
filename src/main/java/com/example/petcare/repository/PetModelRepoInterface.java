package com.example.petcare.repository;

import com.example.petcare.model.Pet;

import java.util.List;

public interface PetModelRepoInterface<T> {
    T create(T t);
    T update(T t, Long id);
    List<T> getAll();
    T getById(Long id);
    void delete(Long id);
}
