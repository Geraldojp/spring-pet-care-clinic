package com.example.petcare.repository;

import com.example.petcare.model.Pet;
import com.example.petcare.model.mapper.PetMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.util.List;

public class PetRepo implements PetModelRepoInterface<Pet> {
    private JdbcTemplate jdbcTemplate;

    public PetRepo(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public Pet create(Pet pet){
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            var ps = connection.prepareStatement("INSERT INTO pet (name, type, breed, color, owner_id) VALUES (?,?,?,?,?)", new String[]{"pet_id"});
            ps.setString(1, pet.getName());
            ps.setString(2, pet.getType());
            ps.setString(3, pet.getBreed());
            ps.setString(4, pet.getColor());
            ps.setLong(5, pet.getOwnerId());
            return ps;
        }, keyHolder);
        return pet;
    }
    @Override
    public Pet update(Pet pet, Long id){
        jdbcTemplate.update("UPDATE pet SET name = ?, type = ?, breed = ?, color = ?, owner_id = ? WHERE pet_id = ?",
                pet.getName(),
                pet.getType(),
                pet.getBreed(),
                pet.getColor(),
                pet.getOwnerId(),
                id);
        return pet;
    }
    @Override
    public List<Pet> getAll(){
        List<Pet> allPet = jdbcTemplate.query("SELECT * FROM pet", new PetMapper());
        return allPet;
    }
    @Override
    public Pet getById(Long id){
        return jdbcTemplate.queryForObject("SELECT * FROM pet WHERE pet_id = ?", new Object[]{id}, new PetMapper());
    }
    @Override
    public void delete(Long id){
        jdbcTemplate.update("DELETE FROM pet WHERE pet_id = ?", id);
    }
}
