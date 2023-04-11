package com.example.petcare.model.mapper;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PetDTO implements RowMapper<PetDTO> {
    @Override
    public PetDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return null;
    }
}
