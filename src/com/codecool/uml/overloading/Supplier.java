package com.codecool.uml.overloading;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Supplier {
    private static int lastId;
    private int id;
    private String name;
    private String description;

    public Supplier() {
        id = ++lastId;
    }

    public Supplier(String name, String description) {
        this();
        this.name = name;
        this.description = description;
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
        return Product.getAllProductsBy(this);
    }

    @Override
    public String toString() {
        Field[] fields = this.getClass().getDeclaredFields();
        fields = Arrays.stream(fields).filter(field -> !Modifier.isStatic(field.getModifiers())).toArray(Field[]::new);
        String[] fieldStrings = new String[fields.length];
        int i = 0;
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                fieldStrings[i++] = field.getName() + ":" + field.get(this);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return String.join(",", fieldStrings);
    }
}
