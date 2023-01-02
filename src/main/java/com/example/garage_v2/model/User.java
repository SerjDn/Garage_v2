package com.example.garage_v2.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class User {
    private int id;
    private String name;
}
