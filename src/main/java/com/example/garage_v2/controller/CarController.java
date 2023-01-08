package com.example.garage_v2.controller;

import com.example.garage_v2.model.Car;
import com.example.garage_v2.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/{id}")
    public Optional<Car> getCar(@PathVariable int id) {
        return this.carService.getCar(id);
    }

    @GetMapping
    public List<Car> getCars() {
        return this.carService.getCars();
    }

    @PostMapping
    public Car addCar(@RequestBody Car car) {
        return this.carService.addCar(car);
    }
}
