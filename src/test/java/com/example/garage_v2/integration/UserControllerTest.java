package com.example.garage_v2.integration;

import com.example.garage_v2.model.Car;
import com.example.garage_v2.model.User;
import com.example.garage_v2.repository.CarRepository;
import com.example.garage_v2.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("dev")
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CarRepository carRepository;

    @Test
    public void getUserTest() throws Exception {
        User tom = new User();
        tom.setName("Tom");
        User user = userRepository.save(tom);

        MvcResult mvcResult = mockMvc.perform(get("/users/" + user.getId()))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }

    @Test
    public void getUsersTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }

    @Test
    public void addUserTest() throws Exception {
        User bob = new User();
        bob.setName("Bob");
        User user = userRepository.save(bob);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                        .post("/users")
                        .content(asJsonString(user))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void addCarToUserTest() throws Exception {
        User alex = new User();
        alex.setName("Alex");
        User user = userRepository.save(alex);

        Car car = carRepository.save(Car.builder()
                .brand("Hyundai")
                .model("Sonata")
                .build());

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                        .post("/users/" + user.getId() + "/" + car.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }
}
