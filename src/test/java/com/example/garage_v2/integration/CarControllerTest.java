package com.example.garage_v2.integration;

import com.example.garage_v2.model.Car;
import com.example.garage_v2.repository.CarRepository;
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
public class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CarRepository carRepository;

    @Test
    public void getCarTest() throws Exception {
        Car car = carRepository.save(Car.builder()
                .brand("Ford")
                .model("Mustang")
                .build());

        MvcResult mvcResult = mockMvc.perform(get("/cars/" + car.getId()))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }

    @Test
    public void getCarsTest() throws Exception {
        Car i10 = carRepository.save(Car.builder()
                .brand("Hyundai")
                .model("i10")
                .build());

        Car i20 = carRepository.save(Car.builder()
                .brand("Hyundai")
                .model("i20")
                .build());

        MvcResult mvcResult = mockMvc.perform(get("/cars"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }

    @Test
    public void addCarTest() throws Exception {
        Car i30 = carRepository.save(Car.builder()
                .brand("Hyundai")
                .model("i30")
                .build());

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                        .post("/cars")
                        .content(asJsonString(i30))
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
}
