package com.example.garage_v2.service;

import com.example.garage_v2.model.Car;
import com.example.garage_v2.repository.CarRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class CarService {

    private final CarRepo carRepo;

    public CarService(CarRepo carRepo) {
        this.carRepo = carRepo;
    }

    public void addCar(Car car) {
        this.carRepo.save(car);
    }

    public Optional<Car> getCar(int id) {
        return this.carRepo.findById(id);
    }

    public List<Car> getCars() {
        return this.carRepo.findAll();
    }
}
