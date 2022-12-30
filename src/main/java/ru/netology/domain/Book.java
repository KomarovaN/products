package ru.netology.domain;

public class Book extends Product {
    String autor;

    public Book(int id, String name, int cost, String autor) {
        super(id, name, cost);
        this.autor = autor;
    }
    public boolean matches(String search) {
        if (super.matches(search)) { // вызов метода matches в версии описанной в Product
            return true;
        }
        return getAutor().contains(search);
    }

    public String getAutor() {
        return autor;
    }
}
