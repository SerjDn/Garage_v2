package com.example.garage_v2.service;

import com.example.garage_v2.model.User;
import com.example.garage_v2.model.UserGarage;
import com.example.garage_v2.repository.CarRepository;
import com.example.garage_v2.repository.UserGarageRepository;
import com.example.garage_v2.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserGarageRepository userGarageRepository;
    private final CarRepository carRepository;

    public UserService(UserRepository userRepository, UserGarageRepository userGarageRepository, CarRepository carRepository) {
        this.userRepository = userRepository;
        this.userGarageRepository = userGarageRepository;
        this.carRepository = carRepository;
    }

    public void addUser(User user) {
        this.userRepository.save(user);
    }

    public List<UserGarage> getUser(int id) {
        return this.userGarageRepository.findUserGarageByUserId(id);
    }

    public List<UserGarage> getUsers() {
        return this.userGarageRepository.findAllUserGarages();
    }

    public void addCarToUser(int userId, int carId) {
        this.carRepository.updateUserCar(userId, carId);
    }
}
