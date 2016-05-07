package ru.kpfu.dm.service;

import ru.kpfu.dm.entity.Cart;
import ru.kpfu.dm.entity.CartProduct;
import ru.kpfu.dm.entity.Product;

/**
 * Created by Denis on 17.04.16.
 */
public interface CartProductService {
    boolean addProduct(Product product);
    Cart getCart();
    void removeProduct(Product product);
    void removeCart(Cart cart);
}

