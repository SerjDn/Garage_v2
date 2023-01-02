package com.example.garage_v2.repository.dao;

import com.example.garage_v2.model.User;
import com.example.garage_v2.model.UserGarage;

import java.util.List;

public interface UserRepository {
    List<UserGarage> getUser(int id);
    List<UserGarage> getUsers();
    void addUser(User user);
    void AddCarToUser(int userId, int carId);
}
