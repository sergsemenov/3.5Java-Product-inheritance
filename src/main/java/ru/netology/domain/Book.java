package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Book extends Product {
    private String author;

    public Book(int id, int price, String name, String author) {
        super(id, price, name);
        this.author = author;
    }

    @Override
    public boolean matches(String search) {
        return super.matches(search) || this.getAuthor().matches(search);
    }
}
