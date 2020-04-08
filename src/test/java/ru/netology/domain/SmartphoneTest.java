package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class SmartphoneTest {

    @Test
    void shouldMatchByBrand() {
        Smartphone smart = new Smartphone(4, 444, "Smart444", "Brand444");
        boolean actual = smart.matches("Brand444");
        assertTrue(actual);
    }

    @Test
    void shouldMatchByName() {
        Smartphone smart = new Smartphone(5, 555, "Smart555", "Brand555");
        boolean actual = smart.matches("Smart555");
        assertTrue(actual);
    }

    @Test
    void shouldNotMatchByBrand() {
        Smartphone smart = new Smartphone(4, 444, "Smart444", "Brand444");
        boolean actual = smart.matches("Brand666");
        assertFalse(actual);
    }

    @Test
    void shouldNotMatchByName() {
        Smartphone smart = new Smartphone(5, 555, "Smart555", "Brand555");
        boolean actual = smart.matches("Smart666");
        assertFalse(actual);
    }
}
