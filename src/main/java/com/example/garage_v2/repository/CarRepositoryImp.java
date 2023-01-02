package com.example.garage_v2.repository;

import com.example.garage_v2.model.Car;
import com.example.garage_v2.repository.dao.CarRepository;
import com.example.garage_v2.repository.mapper.CarMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarRepositoryImp implements CarRepository {

    private final JdbcTemplate jdbcTemplate;

    public CarRepositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addCar(Car car) {
        jdbcTemplate.update("""
                INSERT INTO public.car(
                   	brand, model)
                   	VALUES (?, ?);
                """, car.getBrand(), car.getModel());
    }

    @Override
    public Car getCar(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM public.car WHERE id = " + id, new CarMapper());
    }

    @Override
    public List<Car> getCars() {
        return jdbcTemplate.query("SELECT * FROM public.car", new CarMapper());
    }
}
