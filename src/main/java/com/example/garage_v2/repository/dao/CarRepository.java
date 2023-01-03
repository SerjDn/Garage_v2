package com.example.garage_v2.repository.dao;

import com.example.garage_v2.model.Car;

import java.util.List;

public interface CarRepository {
    void addCar(Car car);
    Car getCar(int id);
    List<Car> getCars();
}
