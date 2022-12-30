package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {

    Product product1 = new Product(1, "Prod I", 100);
    Product product2 = new Product(2, "Prod II", 10_000);
    Product product3 = new Product(3, "Prod III", 1_000_000);
    @Test
    public void shouldSave() {
        ProductRepository repo = new ProductRepository();
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);

        Product[] expected = {product1, product2, product3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        ProductRepository repo = new ProductRepository();
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.removeById(product2.getId());

        Product[] expected = {product1, product3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldExeptionRemoveById() {
        ProductRepository repo = new ProductRepository();
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(-1);
        });
    }

}
