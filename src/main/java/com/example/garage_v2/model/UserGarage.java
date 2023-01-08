package com.example.garage_v2.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;

@Data
@Builder
public class UserGarage {
    @Column("id")
    private int userId;
    @Column("name")
    private String userName;
    @Column("brand")
    private String userCarBrand;
    @Column("model")
    private String userCarModel;
}
