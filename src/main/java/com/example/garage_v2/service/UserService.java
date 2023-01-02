package com.example.garage_v2.service;

import com.example.garage_v2.model.User;
import com.example.garage_v2.model.UserCars;
import com.example.garage_v2.repository.dao.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserCars> getUser(int id) {
        return this.userRepository.getUser(id);
    }

    public List<UserCars> getUsers() {
        return this.userRepository.getUsers();
    }

    public void addUser(User user) {
        this.userRepository.addUser(user);
    }

    public void AddCarToUser(int userId, int carId) {
        this.userRepository.AddCarToUser(userId, carId);
    }
}
