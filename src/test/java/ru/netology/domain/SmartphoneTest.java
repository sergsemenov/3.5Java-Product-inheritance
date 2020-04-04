package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SmartphoneTest {

    @Test
    void shouldMatchesByBrand() {
        Smartphone smart = new Smartphone(4, 444, "Smart444", "Brand444");
        boolean actual = smart.matches("Brand444");
        assertEquals(true, actual);

    }

    @Test
    void shouldMatchesByName() {
        Smartphone smart = new Smartphone(5, 555, "Smart555", "Brand555");
        boolean actual = smart.matches("Smart555");
        assertEquals(true, actual);
    }

    @Test
    void shouldNotMatchesByBrand() {
        Smartphone smart = new Smartphone(4, 444, "Smart444", "Brand444");
        boolean actual = smart.matches("Brand666");
        assertEquals(false, actual);

    }

    @Test
    void shouldNotMatchesByName() {
        Smartphone smart = new Smartphone(5, 555, "Smart555", "Brand555");
        boolean actual = smart.matches("Smart666");
        assertEquals(false, actual);
    }
}
