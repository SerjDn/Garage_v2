package com.example.garage_v2.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserGarage {
    private int userId;
    private String userName;
    private String userCarBrand;
    private String userCarModel;
}
