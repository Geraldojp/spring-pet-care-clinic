package com.example.petcare.model.mapper;

import com.example.petcare.model.PetClinic;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PetClinicMapper implements RowMapper<PetClinic> {
    @Override
    public PetClinic mapRow(ResultSet rs, int rowNum) throws SQLException {
        PetClinic petClinic = new PetClinic();
        petClinic.setPetClinicId(rs.getLong("pet_clinic_id"));
        petClinic.setServiceName(rs.getString("service_name"));
        petClinic.setPrice(rs.getLong("price"));
        petClinic.setDescription(rs.getString("description"));
        return petClinic;
    }
}
