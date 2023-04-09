package com.example.petcare.model.mapper;

import com.example.petcare.model.Pet;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PetMapper implements RowMapper<Pet> {
    @Override
    public Pet mapRow(ResultSet rs, int rowNum) throws SQLException {
        Pet pet = new Pet();
        pet.setPetId(rs.getLong("pet_id"));
        pet.setName(rs.getString("name"));
        pet.setType(rs.getString("type"));
        pet.setBreed(rs.getString("breed"));
        pet.setColor(rs.getString("color"));
        pet.setOwnerId(rs.getLong("owner_id"));
        return pet;
    }
}
