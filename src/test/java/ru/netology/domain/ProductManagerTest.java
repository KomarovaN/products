package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);
    Product productBook1 = new Book(4, "Book I", 1_000, "Autor I");
    Product productBook2 = new Book(6, "Book II", 1_000, "Autor II");
    Product productBook3 = new Book(8, "Book III", 1_000, "Autor III");
    Product productSmart1 = new Smartphone(5, "Smart I", 1_000, "Maker I");
    Product productSmart2 = new Smartphone(7, "Smart II", 1_000, "Maker II");

    @Test
    public void shouldAdd() {
        manager.add(productBook1);
        manager.add(productSmart1);
        manager.add(productBook2);
        manager.add(productBook3);
        manager.add(productSmart2);

        Product[] expected = {productBook1, productSmart1, productBook2, productBook3, productSmart2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchPositive() {
        manager.add(productBook1);
        manager.add(productSmart1);
        manager.add(productBook2);
        manager.add(productBook3);
        manager.add(productSmart2);

        Product[] expected = {productBook1, productBook2, productBook3};
        Product[] actual = manager.searchBy("Book");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchNegative() {
        manager.add(productBook1);
        manager.add(productSmart1);
        manager.add(productBook2);
        manager.add(productBook3);
        manager.add(productSmart2);

        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy("Anything");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchNull() {
        manager.add(productBook1);
        manager.add(productSmart1);
        manager.add(productBook2);
        manager.add(productBook3);
        manager.add(productSmart2);

        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy("");

        Assertions.assertArrayEquals(expected, actual);
    }
}
