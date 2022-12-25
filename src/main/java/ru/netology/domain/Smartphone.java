package ru.netology.domain;

public class Smartphone extends Product {
    String maker;

    public Smartphone(int id, String name, int cost, String maker) {
        super(id, name, cost);
        this.maker = maker;
    }

    public boolean matches(String search) {
        if (super.matches(search)) { // вызов метода matches в версии описанной в Product
            return true;
        }
        return getMaker().contains(search);
    }

    public String getMaker() {
        return maker;
    }

}

