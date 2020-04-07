package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void shouldMatchByAuthor() {
        Book book = new Book(100, 100,"100", "MySelf");
        boolean actual = book.matches("MySelf");
        assertEquals(true, actual);

    }

    @Test
    void shouldMatchByName() {
        Book book = new Book(300, 300,"300", "MySelf");
        boolean actual = book.matches("300");
        assertEquals(true, actual);
    }

    @Test
    void shouldNotMatchByAuthor() {
        Book book = new Book(100, 100,"100", "MySelf");
        boolean actual = book.matches("YourSelf");
        assertEquals(false, actual);

    }

    @Test
    void shouldNotMatchByName() {
        Book book = new Book(300, 300,"300", "MySelf");
        boolean actual = book.matches("400");
        assertEquals(false, actual);
    }
}
