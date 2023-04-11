package com.example.petcare.model.mapper;

import com.example.petcare.model.DTO.PetDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PetDTOMapper implements RowMapper<PetDTO> {
    @Override
    public PetDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        PetDTO pet = new PetDTO();
        pet.setName(rs.getString("name"));
        pet.setType(rs.getString("type"));
        pet.setBreed(rs.getString("breed"));
        pet.setColor(rs.getString("color"));
        pet.setOwnerName(rs.getString("owner_name"));
        return pet;
    }
}
