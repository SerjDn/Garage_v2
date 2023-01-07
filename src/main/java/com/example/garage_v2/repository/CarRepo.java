package com.example.garage_v2.repository;

import com.example.garage_v2.model.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepo extends CrudRepository<Car, Integer> {

    @Override
    List<Car> findAll();
}
