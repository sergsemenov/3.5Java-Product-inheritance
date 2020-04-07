package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.netology.managertest.Book;
import ru.netology.managertest.Product;
import ru.netology.managertest.Smartphone;
import ru.netology.repository.ProductRepository;

@AllArgsConstructor
@Data
public class ProductManager {
    private ProductRepository repository;

    public void add(Product item) {
        repository.save(item);
    }

    public boolean matches(Product product, String search) {
        if (product instanceof Book) {
            Book book = (Book) product;
            if (book.getName().equalsIgnoreCase(search)) {
                return true;
            }
            if (book.getAuthor().equalsIgnoreCase(search)) {
                return true;
            }
            return false;
        }
        if (product instanceof Smartphone) {
            Smartphone smart = (Smartphone) product;
            if (smart.getName().equalsIgnoreCase(search)) {
                return true;
            }
            if (smart.getBrand().equalsIgnoreCase(search)) {
                return true;
            }
        }
        return false;
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }
}
