package com.example.petcare.service;

import com.example.petcare.model.Sales;

import java.time.LocalDate;
import java.util.List;

public interface SalesServiceInterface {
    Sales create(Sales sales);
    Sales update(Sales sales, Long id);
    List<Sales> getAll();
    List<Sales> getDailySales(LocalDate date);
    List<Sales> getMonthlySales(int month, int year);
    void delete(Long id);
}
