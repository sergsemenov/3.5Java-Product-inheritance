package ru.netology.repository;

import ru.netology.product.Book;
import ru.netology.product.Product;
import ru.netology.product.Smartphone;

public class ProductRepository {
    Product[] items = {new Book(1, 100, "BookOne", "AuthorOne"),
            new Book(2, 200, "BookTwo", "AuthorTwo"),
            new Book(3, 300, "BookThree", "AuthorThree"),
            new Smartphone(4, 1000, "SmartOne", "BrandOne"),
            new Smartphone(5, 2000, "SmartTwo", "BrandTwo"),
            new Smartphone(6, 3000, "SmartThree", "BrandThree")
    };

    public void save(Product item) {
        int length = items.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Product[] findAll() {
        return items;
    }

    public Product findById(int id) {
        for (Product item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeById(int id) {
        int length = items.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }
}
