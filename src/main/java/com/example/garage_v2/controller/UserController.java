package com.example.garage_v2.controller;

import com.example.garage_v2.model.User;
import com.example.garage_v2.model.UserGarage;
import com.example.garage_v2.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public List<UserGarage> getUser(@PathVariable int id) {
        return this.userService.getUser(id);
    }

    @GetMapping
    public List<UserGarage> getUsers() {
        return this.userService.getUsers();
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return this.userService.addUser(user);
    }

    @PostMapping("/{userId}/{carId}")
    public void addCarToUser(@PathVariable int userId, @PathVariable int carId) {
        this.userService.addCarToUser(userId, carId);
    }
}
