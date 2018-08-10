package com.codecool.uml.overloading;

import java.util.LinkedList;
import java.util.List;

public class Supplier {
    private int id;
    private String name;
    private String description;

    public Supplier() {
        // TODO
    }

    public Supplier(String name, String description) {
        // TODO
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Product> getProducts() {
        // TODO
        return new LinkedList<Product>();
    }

    @Override
    public String toString() {
        // TODO
        return super.toString();
    }
}
