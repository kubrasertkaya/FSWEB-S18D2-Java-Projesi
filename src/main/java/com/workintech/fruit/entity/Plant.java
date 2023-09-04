package com.workintech.fruit.entity;


import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@MappedSuperclass
public class Plant {
    private int id;
    private String name;
    private double price;
}
