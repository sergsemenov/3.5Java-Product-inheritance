package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Smartphone extends Product {
    private String brand;

    public Smartphone(int id, int price, String name, String brand) {
        super(id, price, name);
        this.brand = brand;
    }

}
