package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest {

    @Test
    void shouldSearchByAuthor() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Product[] expected = {new Book(2, 200, "BookTwo", "AuthorTwo")};
        Product[] actual = manager.searchBy("AuthorTwo");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByBookName() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Product[] expected = {new Book(3, 300, "BookThree", "AuthorThree")};
        Product[] actual = manager.searchBy("BookThree");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByPhoneName() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Product[] expected = {new Smartphone(6, 3000, "SmartThree", "BrandThree")};
        Product[] actual = manager.searchBy("SmartThree");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByBrand() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Product[] expected = {new Smartphone(4, 1000, "SmartOne", "BrandOne")};
        Product[] actual = manager.searchBy("BrandOne");
        assertArrayEquals(expected, actual);
    }
}
