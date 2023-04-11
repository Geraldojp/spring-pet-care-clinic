package com.example.petcare.repository;

import com.example.petcare.model.Owner;
import com.example.petcare.model.Pet;
import com.example.petcare.model.mapper.OwnerMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.util.List;

public class OwnerRepo implements OwnerRepoInterface {
    private JdbcTemplate jdbcTemplate;
    public OwnerRepo(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public Owner create(Owner owner) throws Exception{
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            var ps = connection.prepareStatement("INSERT INTO owner (owner_name, address, city, telephone) VALUES (?,?,?,?)", new String[]{"owner_id"});
            ps.setString(1, owner.getName());
            ps.setString(2, owner.getAddress());
            ps.setString(3, owner.getCity());
            ps.setString(4, owner.getTelephone());
            return ps;
        }, keyHolder);
        owner.setOwnerId(keyHolder.getKey().longValue());
        return owner;
    }
    @Override
    public Owner update(Owner owner, Long id)throws Exception{
        jdbcTemplate.update("UPDATE owner SET owner_name = ?, address = ?, city = ?, telephone = ? WHERE owner_id = ?",
                owner.getName(),
                owner.getAddress(),
                owner.getCity(),
                owner.getTelephone(),
                id);
        return owner;
    }
    @Override
    public List<Owner> getAll()throws Exception{
        List<Owner> listOwner =  jdbcTemplate.query("SELECT * FROM owner ORDER BY owner_id", new OwnerMapper());
        return listOwner;
    }
    @Override
    public Owner getById(Long id)throws Exception{
        Owner owner = jdbcTemplate.queryForObject("SELECT * FROM owner WHERE owner_id = ?", new Object[]{id}, new OwnerMapper());
        System.out.println(owner);
        return owner;
    }
    @Override
    public void delete(Long id)throws Exception{
        jdbcTemplate.update("DELETE FROM owner WHERE owner_id = ?", id);
    }
}
