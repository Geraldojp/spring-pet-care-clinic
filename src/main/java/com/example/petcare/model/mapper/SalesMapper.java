package com.example.petcare.model.mapper;

import com.example.petcare.model.Sales;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SalesMapper implements RowMapper<Sales> {
    @Override
    public Sales mapRow(ResultSet rs, int rowNum) throws SQLException {
        Sales sales = new Sales();
        sales.setTransactionId(rs.getLong("transaction_id"));
        sales.setTransactionDate(rs.getDate("transaction_date").toLocalDate());
        sales.setOwnerId(rs.getLong("owner_id"));
        sales.setPetId(rs.getLong("pet_id"));
        sales.setPetClinicId(rs.getLong("pet_clinic_id"));
        return sales;
    }
}
