package com.codecool.uml.overloading;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Currency;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Product {
    private static int lastId;
    private int id;
    private String name;
    private float defaultPrice;
    private Currency defaultCurrency;
    private ProductCategory productCategory;
    private Supplier supplier;
    private static List<Product> productList;

    public Product() {
        id = ++lastId;
    }

    public Product(String name, float defaultPrice, Currency defaultCurrency) {
        this();
        this.name = name;
        this.defaultPrice = defaultPrice;
        this.defaultCurrency = defaultCurrency;
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

    public float getDefaultPrice() {
        return defaultPrice;
    }

    public void setDefaultPrice(float defaultPrice) {
        this.defaultPrice = defaultPrice;
    }

    public Currency getDefaultCurrency() {
        return defaultCurrency;
    }

    public void setDefaultCurrency(Currency defaultCurrency) {
        this.defaultCurrency = defaultCurrency;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public static List<Product> getAllProductsBy(ProductCategory productCategory) {
        return productList.stream()
                          .filter(product -> product.getProductCategory().equals(productCategory))
                          .collect(Collectors.toList());
    }

    public static List<Product> getAllProductsBy(Supplier supplier) {
        return productList.stream()
                          .filter(product -> product.getSupplier().equals(supplier))
                          .collect(Collectors.toList());
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
