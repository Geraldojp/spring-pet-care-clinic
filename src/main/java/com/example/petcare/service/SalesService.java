package com.example.petcare.service;

import com.example.petcare.model.DTO.SalesDTO;
import com.example.petcare.model.Sales;
import com.example.petcare.repository.SalesRepoInterface;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Transactional
public class SalesService implements SalesServiceInterface {
    private SalesRepoInterface salesRepo;

    public SalesService(SalesRepoInterface salesRepo) {
        this.salesRepo = salesRepo;
    }

    @Override
    public Sales create(Sales sales) {
        try {
            return salesRepo.create(sales);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Sales update(Sales sales, Long id) {
        try {
            return salesRepo.update(sales, id);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<SalesDTO> getAll() {
        try {
            if (salesRepo.getAll().isEmpty())
                System.out.println("Database is empty");
            return salesRepo.getAll();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<SalesDTO> getDailySales(String date) {
        try {
            return salesRepo.getDailySales(date);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;

    }

    @Override
    public List<SalesDTO> getMonthlySales(int month, int year) {
        try {
            return salesRepo.getMonthlySales(month, year);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        try {
            salesRepo.delete(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
