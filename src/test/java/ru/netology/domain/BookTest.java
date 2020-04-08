package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class BookTest {

    @Test
    void shouldMatchByAuthor() {
        Book book = new Book(100, 100,"100", "MySelf");
        boolean actual = book.matches("MySelf");
        assertTrue(actual);

    }

    @Test
    void shouldMatchByName() {
        Book book = new Book(300, 300,"300", "MySelf");
        boolean actual = book.matches("300");
        assertTrue(actual);
    }

    @Test
    void shouldNotMatchByAuthor() {
        Book book = new Book(100, 100,"100", "MySelf");
        boolean actual = book.matches("YourSelf");
        assertFalse(actual);

    }

    @Test
    void shouldNotMatchByName() {
        Book book = new Book(300, 300,"300", "MySelf");
        boolean actual = book.matches("400");
        assertFalse(actual);
    }
}
