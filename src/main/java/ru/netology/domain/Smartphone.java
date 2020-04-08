package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class Smartphone extends Product {
    private String brand;

    public Smartphone(int id, int price, String name, String brand) {
        super(id, price, name);
        this.brand = brand;
    }

    @Override
    public boolean matches(String search) {
        return super.matches(search) || this.getBrand().matches(search);
    }
}
