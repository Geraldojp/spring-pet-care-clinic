package com.example.petcare.service;

import com.example.petcare.model.DTO.PetDTO;

import java.util.List;

public interface PetModelServiceInterface<T> {
    T create (T t);
    T update(T t, Long id);
    List<T> getAll();
    T getById(Long id);
    void delete(Long id);

}
