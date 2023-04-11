package com.example.petcare.repository;

import com.example.petcare.model.DTO.PetDTO;
import com.example.petcare.model.Pet;
import com.example.petcare.model.mapper.PetDTOMapper;
import com.example.petcare.model.mapper.PetMapper;
import org.modelmapper.ModelMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.util.List;

public class PetRepo implements PetRepoInterface {
    private JdbcTemplate jdbcTemplate;
    private ModelMapper modelMapper;

    public PetRepo(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public Pet create(Pet pet)throws Exception{
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            var ps = connection.prepareStatement("INSERT INTO pet (name, type, breed, color, owner_id) VALUES (?, ?, ?, ?, ?)", new String[]{"pet_id"});
            ps.setString(1, pet.getName());
            ps.setString(2, pet.getType());
            ps.setString(3, pet.getBreed());
            ps.setString(4, pet.getColor());
            ps.setLong(5, pet.getOwnerId());
            return ps;
        }, keyHolder);
        pet.setPetId(keyHolder.getKey().longValue());
        return pet;
    }
    @Override
    public Pet update(Pet pet, Long id)throws Exception{
        jdbcTemplate.update("UPDATE pet SET name = ?, type = ?, breed = ?, color = ?, owner_id = ? WHERE pet_id = ?",
                pet.getName(), pet.getType(), pet.getBreed(), pet.getColor(), pet.getOwnerId(), id);
        return pet;
    }
    @Override
    public List<PetDTO> getAll()throws Exception{
        List<PetDTO> allPetDTO = jdbcTemplate.query("SELECT pet.pet_id, pet.name, pet.type, pet.breed, pet.color, pet.owner_id, owner.owner_name " +
                "FROM pet JOIN owner ON pet.owner_id = owner.owner_id", new PetDTOMapper());
        return allPetDTO;
    }
    @Override
    public PetDTO getById(Long id)throws Exception{
        PetDTO petDTO = jdbcTemplate.
                queryForObject("SELECT pet.pet_id, " +
                        "pet.name, " +
                        "pet.type, " +
                        "pet.breed, " +
                        "pet.color, " +
                        "pet.owner_id, " +
                        "owner.owner_name " +
                        "FROM pet JOIN owner ON pet.owner_id = owner.owner_id WHERE pet_id = ?", new PetDTOMapper(), id);
        return petDTO;
    }
    @Override
    public void delete(Long id)throws Exception{
        jdbcTemplate.update("DELETE FROM pet WHERE pet_id = ?", id);
    }

}
