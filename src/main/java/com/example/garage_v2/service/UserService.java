package com.example.garage_v2.service;

import com.example.garage_v2.model.User;
import com.example.garage_v2.model.UserGarage;
import com.example.garage_v2.repository.CarRepo;
import com.example.garage_v2.repository.UserGarageRepo;
import com.example.garage_v2.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepo userRepo;
    private final UserGarageRepo userGarageRepo;
    private final CarRepo carRepo;

    public UserService(UserRepo userRepo, UserGarageRepo userGarageRepo, CarRepo carRepo) {
        this.userRepo = userRepo;
        this.userGarageRepo = userGarageRepo;
        this.carRepo = carRepo;
    }

    public void addUser(User user) {
        this.userRepo.save(user);
    }

    public List<UserGarage> getUser(int id) {
        return this.userGarageRepo.findUserGarageByUserId(id);
    }

    public List<UserGarage> getUsers() {
        return this.userGarageRepo.findAllUserGarages();
    }

    public void AddCarToUser(int userId, int carId) {
        this.carRepo.updateUserCar(userId, carId);
    }
    //TODO: 08.01.2023  rename AddCarToUser to addCarToUser
    //TODO: 08.01.2023  rename all Repo to Repository
    //TODO: 08.01.2023  delete all old Repositories
}
