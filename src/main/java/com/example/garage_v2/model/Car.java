package com.example.garage_v2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@Table("car")
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Id
    private int id;
    private String brand;
    private String model;
}
