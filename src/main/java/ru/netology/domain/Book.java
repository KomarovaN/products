package ru.netology.domain;

public class Book extends Product {
    String autor;

    public Book(int id, String name, int cost, String autor) {
        super(id, name, cost);
        this.autor = autor;
    }
}
