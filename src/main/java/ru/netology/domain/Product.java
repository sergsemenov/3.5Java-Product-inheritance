package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    private int id;
    private int price;
    private String name;

    public boolean matches(String search) {
        if (this.getName().matches(search)) {
            return true;
        }
        return false;
    }
}
