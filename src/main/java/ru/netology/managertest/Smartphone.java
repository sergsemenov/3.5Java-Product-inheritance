package ru.netology.managertest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class Smartphone extends Product {
    private String brand;

    public Smartphone(int id, int price, String name, String brand) {
        super(id, price, name);
        this.brand = brand;
    }
}
