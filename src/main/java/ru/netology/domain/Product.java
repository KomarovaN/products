package ru.netology.domain;

public class Product {
    protected int id;
    protected String name;
    protected int cost;

    public Product(int id, String name, int cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    public boolean matches(String search) {
        return getName().contains(search);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

