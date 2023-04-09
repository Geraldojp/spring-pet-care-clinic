package com.example.petcare.model.mapper;

import com.example.petcare.model.Owner;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OwnerMapper implements RowMapper<Owner> {
    @Override
    public Owner mapRow(ResultSet rs, int rowNum) throws SQLException {
        Owner owner = new Owner();
        owner.setOwnerId(rs.getLong("owner_id"));
        owner.setName(rs.getString("name"));
        owner.setAddress(rs.getString("address"));
        owner.setCity(rs.getString("city"));
        owner.setTelephone(rs.getString("telephone"));
        return owner;
    }
}
