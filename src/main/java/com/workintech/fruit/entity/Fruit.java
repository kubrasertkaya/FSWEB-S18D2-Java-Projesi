package com.workintech.fruit.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "fruit",schema = "spring")
public class Fruit extends Plant{

    @Column(name = "fruit_type")
    @Enumerated(EnumType.STRING)
    private FruitType type;
}
