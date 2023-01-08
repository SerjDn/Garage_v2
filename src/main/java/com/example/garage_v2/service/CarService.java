package com.example.garage_v2.service;

import com.example.garage_v2.model.Car;
import com.example.garage_v2.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car addCar(Car car) {
        return this.carRepository.save(car);
    }

    public Optional<Car> getCar(int id) {
        return this.carRepository.findById(id);
    }

    public List<Car> getCars() {
        return this.carRepository.findAll();
    }
}
