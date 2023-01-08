package com.example.garage_v2.service;

import com.example.garage_v2.model.Car;
import com.example.garage_v2.repository.CarRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;

@ExtendWith(MockitoExtension.class)
public class CarServiceTest {

    @Mock
    public CarRepository carRepository;

    private CarService carService;

    @BeforeEach
    public void init() {
        this.carService = new CarService(carRepository);
    }

    @Test
    public void addCarTest() {
        Car i30 = Car.builder().id(30).brand("Hyundai").model("i30").build();
        Mockito.when(carRepository.save(any())).thenReturn(i30);
        Car fakeCar = carService.addCar(Car.builder().id(0).brand("FakeBrand").model("FakeModel").build());
        Assertions.assertEquals(i30, fakeCar);
    }

    @Test
    public void getCarTest() {
        Optional<Car> i20 = Optional.of(Car.builder().id(20).brand("Hyundai").model("i20").build());
        Mockito.when(carRepository.findById(any())).thenReturn(i20);
        Optional<Car> fakeCar = carService.getCar(anyInt());
        Assertions.assertEquals(i20, fakeCar);
    }

    @Test
    public void getCarNotFoundTest() {
        Mockito.when(carRepository.findById(any())).thenReturn(Optional.empty());
        Optional<Car> fakeCar = carService.getCar(anyInt());
        Assertions.assertEquals(Optional.empty(), fakeCar);
    }

    @Test
    public void getCarsTest() {
        Car i10 = Car.builder().id(10).brand("Hyundai").model("i10").build();
        Car veloster = Car.builder().id(40).brand("Hyundai").model("veloster").build();
        List<Car> cars = new ArrayList<>();
        cars.add(i10);
        cars.add(veloster);

        Mockito.when(carRepository.findAll()).thenReturn(cars);
        List<Car> fakeCars = carService.getCars();
        Assertions.assertEquals(cars, fakeCars);
    }
}
