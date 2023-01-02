package com.example.garage_v2.repository.mapper;

import com.example.garage_v2.model.UserCars;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserCarsMapper implements RowMapper<UserCars> {

    @Override
    public UserCars mapRow(ResultSet rs, int rowNum) throws SQLException {
        return UserCars.builder()
                .userId(rs.getInt("id"))
                .userName(rs.getString("name"))
                .userCarBrand(rs.getString("brand"))
                .userCarModel(rs.getString("model"))
                .build();
    }
}
