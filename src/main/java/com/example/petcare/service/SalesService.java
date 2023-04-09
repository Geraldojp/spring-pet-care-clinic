package com.example.petcare.service;

import com.example.petcare.model.Sales;
import com.example.petcare.repository.SalesRepoInterface;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Transactional
public class SalesService implements SalesServiceInterface {
    private SalesRepoInterface salesRepo;

    public SalesService(SalesRepoInterface salesRepo) {
        this.salesRepo = salesRepo;
    }

    @Override
    public Sales create(Sales sales) {
        return salesRepo.create(sales);

    }

    @Override
    public Sales update(Sales sales, Long id) {
        return salesRepo.update(sales, id);
    }

    @Override
    public List<Sales> getAll() {
        return salesRepo.getAll();
    }

    @Override
    public List<Sales> getDailySales(LocalDate date) {
        return salesRepo.getDailySales(date);
    }

    @Override
    public List<Sales> getMonthlySales(int month, int year) {
        return salesRepo.getMonthlySales(month, year);
    }

    @Override
    public void delete(Long id) {
        salesRepo.delete(id);
    }
}
