package com.example.petcare.model.mapper;

import com.example.petcare.model.DTO.SalesDTO;
import com.example.petcare.model.Sales;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SalesDTOMapper implements RowMapper<SalesDTO> {

    @Override
    public SalesDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        SalesDTO sales = new SalesDTO();
        sales.setDate(rs.getDate("transaction_date").toLocalDate());
        sales.setPetName(rs.getString("pet_name"));
        sales.setOwnerName(rs.getString("owner_name"));
        sales.setPetServiceName(rs.getString("service_name"));
        sales.setPetServicePrice(rs.getLong("price"));
        return sales;
    }
}
