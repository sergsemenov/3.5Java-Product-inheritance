package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Product itemToAdd = new Book(999, 999, "BookTest", "AuthorTest");

    @Test
    void shouldSave() {
        repository.save(itemToAdd);
        Product[] actual = repository.findAll();
        Product[] expected = {new Book(1, 100, "BookOne", "AuthorOne"),
                new Book(2, 200, "BookTwo", "AuthorTwo"),
                new Book(3, 300, "BookThree", "AuthorThree"),
                new Smartphone(4, 1000, "SmartOne", "BrandOne"),
                new Smartphone(5, 2000, "SmartTwo", "BrandTwo"),
                new Smartphone(6, 3000, "SmartThree", "BrandThree"),
                new Book(999, 999, "BookTest", "AuthorTest")
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindByIdPositive() {
        Product actual = repository.findById(1);
        Product expected = new Book(1, 100, "BookOne", "AuthorOne");
        assertEquals(expected, actual);
    }

    @Test
    void shouldFindByIdNegative() {
        Product actual = repository.findById(11111);
        Product expected = null;
        assertEquals(expected, actual);
    }

    @Test
    void schouldRemoveByIdPositive() {
        repository.removeById(1);
        Product[] actual = repository.findAll();
        Product[] expected = {new Book(2, 200, "BookTwo", "AuthorTwo"),
                new Book(3, 300, "BookThree", "AuthorThree"),
                new Smartphone(4, 1000, "SmartOne", "BrandOne"),
                new Smartphone(5, 2000, "SmartTwo", "BrandTwo"),
                new Smartphone(6, 3000, "SmartThree", "BrandThree")
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    void schouldRemoveByIdNegative() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> repository.removeById(11111));
    }
}
