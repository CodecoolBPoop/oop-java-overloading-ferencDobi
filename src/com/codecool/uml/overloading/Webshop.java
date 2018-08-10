package com.codecool.uml.overloading;

import java.util.Currency;
import java.util.Date;

public class Webshop {

    public static void main(String[] args) {
        Product prod = new Product();
        Product prod2 = new Product("name", 12.5F, Currency.getInstance("HUF"));
        Supplier supp = new Supplier();
        Supplier supp2 = new Supplier("name", "desc");
        ProductCategory prodcat = new ProductCategory();
        ProductCategory prodcat2 = new ProductCategory("name", "dept", "desc");
        FeaturedProductCategory prodcat3 = new FeaturedProductCategory();
        prodcat3.schedule(new Date(), new Date());
        System.out.println(prod.toString());
        System.out.println(prod2.toString());
        System.out.println(supp.toString());
        System.out.println(supp2.toString());
        System.out.println(prodcat.toString());
        System.out.println(prodcat2.toString());
        System.out.println(prodcat3.toString());
    }
}
