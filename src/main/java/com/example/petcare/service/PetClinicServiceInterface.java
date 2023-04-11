package com.example.petcare.service;

import java.util.List;

public interface PetServiceInterface<T> {
    T create (T t);
    T update(T t, Long id);
    List<T> getAll();
    T getById(Long id);
    void delete(Long id);

}
