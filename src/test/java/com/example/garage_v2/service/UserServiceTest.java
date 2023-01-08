package com.example.garage_v2.service;

import com.example.garage_v2.model.Car;
import com.example.garage_v2.model.User;
import com.example.garage_v2.model.UserGarage;
import com.example.garage_v2.repository.CarRepository;
import com.example.garage_v2.repository.UserGarageRepository;
import com.example.garage_v2.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    public UserRepository userRepository;

    @Mock
    public UserGarageRepository userGarageRepository;

    @Mock
    public CarRepository carRepository;

    private UserService userService;

    @BeforeEach
    public void init() {
        this.userService = new UserService(userRepository, userGarageRepository, carRepository);
    }

    @Test
    public void addUserTest() {
        User vova = new User();
        vova.setId(100);
        vova.setName("Vova");

        Mockito.when(userRepository.save(any())).thenReturn(vova);
        User fakeUser = userService.addUser(null);
        Assertions.assertEquals(vova, fakeUser);
    }

    @Test
    public void getUserTest() {
        UserGarage userGarage = UserGarage.builder().userId(50).userName("Sveta").userCarBrand("BMW").userCarModel("X3").build();
        List<UserGarage> userGarageList = new ArrayList<>();
        userGarageList.add(userGarage);

        Mockito.when(userGarageRepository.findUserGarageByUserId(anyInt())).thenReturn(userGarageList);
        List<UserGarage> fakeList = userService.getUser(anyInt());
        Assertions.assertEquals(userGarageList, fakeList);
    }

    @Test
    public void getUsersTest() {
        UserGarage firstUserGarage = UserGarage.builder().userId(60).userName("Tom").userCarBrand("Audi").userCarModel("A3").build();
        UserGarage secondUserGarage = UserGarage.builder().userId(70).userName("Tom").userCarBrand("Audi").userCarModel("A4").build();
        List<UserGarage> userGarages = new ArrayList<>();
        userGarages.add(firstUserGarage);
        userGarages.add(secondUserGarage);

        Mockito.when(userGarageRepository.findAllUserGarages()).thenReturn(userGarages);
        List<UserGarage> fakeGarages = userService.getUsers();
        Assertions.assertEquals(userGarages, fakeGarages);
    }

    @Test
    public void addCarToUserTest() {
        User john = new User();
        john.setId(100);
        john.setName("John");
        Car focus = Car.builder().id(50).brand("Ford").model("Focus").build();

        UserGarage johnsGarage = UserGarage.builder().userId(100).userName("John").userCarBrand("Ford").userCarModel("Focus").build();
        UserGarage garage = updateUserCar(john, focus);

        Assertions.assertEquals(johnsGarage, garage);
    }

    private UserGarage updateUserCar(User user, Car car) {
        return UserGarage.builder()
                .userId(user.getId())
                .userName(user.getName())
                .userCarBrand(car.getBrand())
                .userCarModel(car.getModel())
                .build();
    }
}
