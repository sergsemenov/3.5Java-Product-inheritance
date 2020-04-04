package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book extends Product {
    private String author;

    public Book(int id, int price, String name, String author) {
        super(id, price, name);
        this.author = author;
    }

//    @Override
//    public boolean matches(String search) {
//        return super.matches(search) || this.getAuthor().matches(search);
//    }

    @Override
    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        }
        return super.matches(search) || this.getAuthor().matches(search);
    }
}
