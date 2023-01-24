package com.example.garage_v2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@Table("car")
@AllArgsConstructor
@NoArgsConstructor
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
