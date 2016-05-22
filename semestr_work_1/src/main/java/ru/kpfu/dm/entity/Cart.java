package ru.kpfu.dm.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Denis on 06.05.16.
 */
public class Cart {

    private List<CartProduct> cartProducts;

    public Cart() {
        cartProducts = new ArrayList<CartProduct>();
    }

    public Cart(List<CartProduct> cartProducts) {
        this.cartProducts = cartProducts;
    }

    public int getSize() {
        int size = 0;

        for (CartProduct cartProduct : cartProducts) {
            size += cartProduct.getCount();
        }

        return size;
    }

    public float getPrice() {
        float price = 0;
        for (CartProduct cartProduct : cartProducts) {
            price += cartProduct.getProduct().getPrice() * cartProduct.getCount();
        }

        return price;
    }

    public List<CartProduct> getCartProducts() {
        return cartProducts;
    }

    public void setProducts(List<CartProduct> cartProducts) {
        this.cartProducts = cartProducts;
    }

    public void addProduct(Product product) {

        for (CartProduct cartProduct : cartProducts) {
            if (cartProduct.getProduct().equals(product)) {
                cartProduct.setCount(cartProduct.getCount() + 1);
                return;
            }
        }

        CartProduct newCartProduct = new CartProduct();
        newCartProduct.setProduct(product);
        newCartProduct.setCount(1);

        this.cartProducts.add(newCartProduct);
    }

    public void removeProduct(Product product) {
        for (CartProduct cartProduct : cartProducts) {
            if (cartProduct.getProduct().equals(product) && !cartProduct.getCount().equals(1)) {
                cartProduct.setCount(cartProduct.getCount() - 1);
                return;
            }
        }

        CartProduct removedCartProduct = new CartProduct();
        removedCartProduct.setProduct(product);
        removedCartProduct.setCount(1);

        cartProducts.remove(removedCartProduct);
    }


}
