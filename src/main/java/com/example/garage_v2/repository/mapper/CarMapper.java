package com.example.garage_v2.repository.mapper;

import com.example.garage_v2.model.Car;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarMapper implements RowMapper<Car> {

    @Override
    public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Car.builder()
                .id(rs.getInt("id"))
                .brand(rs.getString("brand"))
                .model(rs.getString("model"))
                .build();
    }
}
