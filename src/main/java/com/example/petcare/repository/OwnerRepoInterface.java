package com.example.petcare.repository;

import com.example.petcare.model.Owner;

import java.util.List;

public interface OwnerRepoInterface{
    Owner create(Owner owner) throws Exception;
    Owner update(Owner owner, Long id) throws Exception;
    List<Owner> getAll() throws Exception;
    Owner getById(Long id) throws Exception;
    void delete(Long id) throws Exception;
}
