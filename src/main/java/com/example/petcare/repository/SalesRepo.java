package com.example.petcare.repository;

import com.example.petcare.model.DTO.SalesDTO;
import com.example.petcare.model.Sales;
import com.example.petcare.model.mapper.SalesDTOMapper;
import com.example.petcare.model.mapper.SalesMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class SalesRepo implements SalesRepoInterface{
    private final JdbcTemplate jdbcTemplate;

    public SalesRepo(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Sales create(Sales sales)throws Exception {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            var ps = connection.prepareStatement("INSERT INTO sales (transaction_date, pet_id, pet_clinic_id, owner_id) VALUES (?,?,?,?)", new String[]{"transaction_id"});
            ps.setObject(1, sales.getTransactionDate());
            ps.setLong(2, sales.getPetId());
            ps.setLong(3, sales.getPetClinicId());
            ps.setLong(4, sales.getOwnerId());
            return ps;
        }, keyHolder);
        sales.setTransactionId(keyHolder.getKey().longValue());
        return sales;
    }

    @Override
    public Sales update(Sales sales, Long id)throws Exception {
        jdbcTemplate.update("UPDATE sales SET transaction_date = ?, pet_id = ?, pet_clinic_id = ?, owner_id = ? WHERE transaction_id = ?",
                sales.getTransactionDate(),
                sales.getPetId(),
                sales.getPetClinicId(),
                sales.getOwnerId(),
                id);
        return sales;
    }

    @Override
    public List<SalesDTO> getAll()throws Exception {
        return jdbcTemplate.query("SELECT sales.transaction_date, pet.name AS pet_name, owner.owner_name, pet_clinic.service_name, pet_clinic.price " +
                        "FROM sales " +
                        "JOIN pet ON sales.pet_id = pet.pet_id " +
                        "JOIN pet_clinic ON sales.pet_clinic_id = pet_clinic.pet_clinic_id " +
                        "JOIN owner ON sales.owner_id = owner.owner_id",
                new SalesDTOMapper());
    }

    @Override
    public List<SalesDTO> getDailySales(String date)throws Exception {
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return jdbcTemplate.query("SELECT sales.transaction_date, pet.name AS pet_name, owner.owner_name, pet_clinic.service_name, pet_clinic.price " +
                "FROM sales " +
                "JOIN pet ON sales.pet_id = pet.pet_id " +
                "JOIN pet_clinic ON sales.pet_clinic_id = pet_clinic.pet_clinic_id " +
                "JOIN owner ON sales.owner_id = owner.owner_id " +
                "WHERE sales.transaction_date = ?", new Object[]{localDate}, new SalesDTOMapper());
    }

    @Override
    public List<SalesDTO> getMonthlySales(int month, int year)throws Exception {
        return jdbcTemplate.query("SELECT sales.transaction_date, pet.name AS pet_name, owner.owner_name, pet_clinic.service_name, pet_clinic.price " +
                        "FROM sales " +
                        "JOIN pet ON sales.pet_id = pet.pet_id " +
                        "JOIN pet_clinic ON sales.pet_clinic_id = pet_clinic.pet_clinic_id " +
                        "JOIN owner ON sales.owner_id = owner.owner_id " +
                        "WHERE EXTRACT(MONTH FROM sales.transaction_date) = ? AND EXTRACT(YEAR FROM sales.transaction_date) = ?",
                new Object[]{month, year}, new SalesDTOMapper());
    }

    @Override
    public void delete(Long id)throws Exception {
        jdbcTemplate.update("DELETE FROM sales WHERE transaction_id = ?", id);
    }
}