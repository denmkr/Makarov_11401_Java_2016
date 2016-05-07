package ru.kpfu.dm.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Denis on 06.05.16.
 */
public class Cart {

    private List<Product> products;

    public Cart() {
        products = new ArrayList<Product>();
    }

    public Cart(List<Product> products) {
        this.products = products;
    }

    public int getSize() {
        return products.size();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }


}
