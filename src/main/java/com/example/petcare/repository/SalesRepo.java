package com.example.petcare.repository;

import com.example.petcare.model.Sales;
import com.example.petcare.model.mapper.SalesMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class SalesRepo implements SalesRepoInterface{
    private JdbcTemplate jdbcTemplate;

    public SalesRepo(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public Sales create(Sales sales) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            var ps = connection.prepareStatement("INSERT INTO sales (transaction_date, pet_id, pet_clinic_id, owner_id) VALUES (?,?,?,?)", new String[]{"transaction_id"});
            ps.setObject(1, sales.getTransactionDate());
            ps.setLong(2, sales.getPetId());
            ps.setLong(3, sales.getPetClinicId());
            ps.setLong(4, sales.getOwnerId());
            return ps;
        }, keyHolder);
        return sales;
    }

    @Override
    public Sales update(Sales sales, Long id) {
        jdbcTemplate
                .update("UPDATE sales SET transaction_date = ?, pet_id = ?, pet_clinic_id = ?, owner_id = ? WHERE transaction_id = ?",
                        sales.getTransactionDate(),
                        sales.getPetId(),
                        sales.getPetClinicId(),
                        sales.getOwnerId(),
                        id);
        return sales;
    }

    @Override
    public List<Sales> getAll() {
        return jdbcTemplate.query("SELECT * FROM sales", new SalesMapper());
    }

    @Override
    public List<Sales> getDailySales(LocalDate date) {
        return jdbcTemplate.query("SELECT * FROM sales WHERE transaction_date = ?", new Object[]{date}, new SalesMapper());
    }

    @Override
    public List<Sales> getMonthlySales(int month, int year) {
        return jdbcTemplate.query("SELECT * FROM sales WHERE EXTRACT(MONTH FROM transaction_date) = ? AND EXTRACT(YEAR FROM transaction_date) = ?", new Object[]{month, year}, new SalesMapper());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM sales WHERE transaction_id = ?", id);

    }
}
