package com.example.petcare.repository;

import com.example.petcare.model.DTO.SalesDTO;
import com.example.petcare.model.Sales;

import java.time.LocalDate;
import java.util.List;

public interface SalesRepoInterface {
    Sales create(Sales sales) throws Exception;
    Sales update(Sales sales, Long id) throws Exception;
    List<SalesDTO> getAll() throws Exception;
    List<SalesDTO> getDailySales(String date) throws Exception;
    List<SalesDTO> getMonthlySales(int month, int year) throws Exception;
    void delete(Long id) throws Exception;


}
