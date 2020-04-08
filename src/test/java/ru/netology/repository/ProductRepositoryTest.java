package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();

    private Product testitem1 = new Book(1, 100, "BookOne", "AuthorOne");
    private Product testitem2 = new Book(2, 200, "BookTwo", "AuthorTwo");
    private Product testitem3 = new Book(3, 300, "BookThree", "AuthorThree");
    private Product testitem4 = new Smartphone(4, 1000, "SmartOne", "BrandOne");
    private Product testitem5 = new Smartphone(5, 2000, "SmartTwo", "BrandTwo");
    private Product testitem6 = new Smartphone(6, 3000, "SmartThree", "BrandThree");

    private Product itemToAdd = new Book(999, 999, "BookTest", "AuthorTest");

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
    void shouldSave() {
        repository.save(itemToAdd);
        Product[] actual = repository.findAll();
        Product[] expected = {
                testitem1,
                testitem2,
                testitem3,
                testitem4,
                testitem5,
                testitem6,
                itemToAdd
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindByIdPositive() {
        Product actual = repository.findById(1);
        Product expected = testitem1;
        assertEquals(expected, actual);
    }

    @Test
    void shouldFindByIdNegative() {
        Product actual = repository.findById(11111);
        assertEquals(null, actual);
    }

    @Test
    void shouldRemoveByIdPositive() {
        repository.removeById(1);
        Product[] actual = repository.findAll();
        Product[] expected = {
                testitem2,
                testitem3,
                testitem4,
                testitem5,
                testitem6
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveByIdNegative() {
        assertThrows(NotFoundException.class, () -> repository.removeById(11111));
    }
}
