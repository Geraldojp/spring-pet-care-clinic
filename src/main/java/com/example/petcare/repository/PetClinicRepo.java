package com.example.petcare.repository;

import com.example.petcare.model.Pet;
import com.example.petcare.model.PetClinic;
import com.example.petcare.model.mapper.PetClinicMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import com.example.petcare.repository.PetClinicRepoInterface;

import javax.sql.DataSource;
import java.util.List;


public class PetClinicRepo implements PetClinicRepoInterface  {
    private JdbcTemplate jdbcTemplate;

    public PetClinicRepo(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public PetClinic create(PetClinic petClinic)throws Exception  {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            var ps = connection.prepareStatement("INSERT INTO pet_clinic (service_name, price, description) VALUES (?,?,?)", new String[]{"pet_clinic_id"});
            ps.setString(1, petClinic.getServiceName());
            ps.setDouble(2, petClinic.getPrice());
            ps.setString(3, petClinic.getDescription());
            return ps;
        }, keyHolder);
        return petClinic;
    }

    @Override
    public PetClinic update(PetClinic petClinic, Long id)throws Exception {
        jdbcTemplate.update("UPDATE pet_clinic SET service_name = ?, price = ?, description = ? WHERE pet_clinic_id = ?",
                petClinic.getServiceName(),
                petClinic.getPrice(),
                petClinic.getDescription(),
                id);
        return petClinic;
    }
    @Override
    public List<PetClinic> getAll() throws Exception{
        return jdbcTemplate.query("SELECT * FROM pet_clinic", new PetClinicMapper());
    }

    @Override
    public PetClinic getById(Long id)throws Exception {
        return jdbcTemplate.queryForObject("SELECT * FROM pet_clinic WHERE pet_clinic_id = ?", new Object[]{id}, new PetClinicMapper());
    }

    @Override
    public void delete(Long id)throws Exception {
        jdbcTemplate.update("DELETE FROM pet_clinic WHERE pet_clinic_id = ?", id);
    }
}

