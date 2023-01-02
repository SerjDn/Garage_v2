package com.example.garage_v2.repository.dao;

import com.example.garage_v2.model.User;
import com.example.garage_v2.model.UserCars;

import java.util.List;

public interface UserRepository {
    List<UserCars> getUser(int id);
    List<UserCars> getUsers();
    void addUser(User user);
    void AddCarToUser(int userId, int carId);
}
