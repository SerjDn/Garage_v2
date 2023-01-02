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

    private static final String insertCar = """
            INSERT INTO public.car(
                brand, model)
                VALUES (?, ?)
            """;

    private static final String selectCar = """
            SELECT * FROM public.car
                WHERE id =
            """;

    private static final String selectCars = """
            SELECT * FROM public.car
                ORDER BY id ASC
            """;

    @Override
    public void addCar(Car car) {
        jdbcTemplate.update(insertCar, car.getBrand(), car.getModel());
    }

    @Override
    public Car getCar(int id) {
        return jdbcTemplate.queryForObject(selectCar + id, new CarMapper());
    }

    @Override
    public List<Car> getCars() {
        return jdbcTemplate.query(selectCars, new CarMapper());
    }
}
