package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void shouldMatchesByAuthor() {
        Book book = new Book(100, 100,"100", "MySelf");
        boolean actual = book.matches("MySelf");
        assertEquals(true, actual);

    }

    @Test
    void shouldMatchesByName() {
        Book book = new Book(300, 300,"300", "MySelf");
        boolean actual = book.matches("300");
        assertEquals(true, actual);
    }

    @Test
    void shouldNotMatchesByAuthor() {
        Book book = new Book(100, 100,"100", "MySelf");
        boolean actual = book.matches("YourSelf");
        assertEquals(false, actual);

    }

    @Test
    void shouldNotMatchesByName() {
        Book book = new Book(300, 300,"300", "MySelf");
        boolean actual = book.matches("400");
        assertEquals(false, actual);
    }
}
