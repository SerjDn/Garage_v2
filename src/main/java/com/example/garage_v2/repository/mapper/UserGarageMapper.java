package com.example.garage_v2.repository.mapper;

import com.example.garage_v2.model.UserGarage;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserGarageMapper implements RowMapper<UserGarage> {

    @Override
    public UserGarage mapRow(ResultSet rs, int rowNum) throws SQLException {
        return UserGarage.builder()
                .userId(rs.getInt("id"))
                .userName(rs.getString("name"))
                .userCarBrand(rs.getString("brand"))
                .userCarModel(rs.getString("model"))
                .build();
    }
}
