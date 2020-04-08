package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    private Product testitem1 = new Book(1, 100, "BookOne", "AuthorOne");
    private Product testitem2 = new Book(2, 200, "BookTwo", "AuthorTwo");
    private Product testitem3 = new Book(3, 300, "BookThree", "AuthorThree");
    private Product testitem4 = new Smartphone(4, 1000, "SmartOne", "BrandOne");
    private Product testitem5 = new Smartphone(5, 2000, "SmartTwo", "BrandTwo");
    private Product testitem6 = new Smartphone(6, 3000, "SmartThree", "BrandThree");

    @BeforeEach
    void SetUp() {
        repository.save(testitem1);
        repository.save(testitem2);
        repository.save(testitem3);
        repository.save(testitem4);
        repository.save(testitem5);
        repository.save(testitem6);
    }

    @Test
    void shouldSearchByAuthor() {
        Product[] actual = manager.searchBy("AuthorTwo");
        Product[] expected = new Product[]{testitem2};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByBookName() {
        Product[] actual = manager.searchBy("BookThree");
        Product[] expected = new Product[]{testitem3};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByPhoneName() {
        Product[] actual = manager.searchBy("SmartThree");
        Product[] expected = new Product[]{testitem6};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByBrand() {
        Product[] actual = manager.searchBy("BrandOne");
        Product[] expected = new Product[]{testitem4};
        assertArrayEquals(expected, actual);
    }
}
