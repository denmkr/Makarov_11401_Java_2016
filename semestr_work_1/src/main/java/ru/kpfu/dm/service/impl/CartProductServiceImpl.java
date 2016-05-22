package ru.kpfu.dm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.dm.entity.Cart;
import ru.kpfu.dm.entity.CartProduct;
import ru.kpfu.dm.entity.Product;
import ru.kpfu.dm.repository.CartProductRepository;
import ru.kpfu.dm.service.CartProductService;
import ru.kpfu.dm.service.ProductService;
import ru.kpfu.dm.service.UserService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CartProductServiceImpl implements CartProductService {

    @Resource
    public CartProductRepository cartProductRepository;
    @Autowired
    public UserService userService;
    @Autowired
    public ProductService productService;

    @Override
    @Transactional
    public boolean addProduct(Product product) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        CartProduct cartProduct;
        cartProduct = cartProductRepository.findByUserIdAndProductId(userService.findByUsername(authentication.getName()).getId(), productService.findByArticule(product.getArticule()).getId());

        if (cartProduct != null) {
            int count = cartProduct.getCount();
            product = productService.findByArticule(product.getArticule());
            cartProductRepository.updateProductInCart(count + 1, userService.findByUsername(authentication.getName()).getId(), product);
        }
        else {
            cartProduct = new CartProduct();
            cartProduct.setProduct(productService.findByArticule(product.getArticule()));
            cartProduct.setUserId(userService.findByUsername(authentication.getName()).getId());
            cartProduct.setCount(1);
            cartProductRepository.saveAndFlush(cartProduct);
        }

        return true;

    }

    @Override
    @Transactional
    public Cart getCart() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        List<CartProduct> cartProducts = cartProductRepository.findByUserId(userService.findByUsername(authentication.getName()).getId());

        Cart cart = new Cart();
        cart.setProducts(cartProducts);

        return cart;
    }

    @Override
    @Transactional
    public boolean removeProduct(Product product) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CartProduct cartProduct = cartProductRepository.findByUserIdAndProductId(userService.findByUsername(authentication.getName()).getId(), productService.findByArticule(product.getArticule()).getId());

        int count = cartProduct.getCount();
        if (count > 1) {
            product = productService.findByArticule(product.getArticule());
            cartProductRepository.updateProductInCart(count - 1, userService.findByUsername(authentication.getName()).getId(), product);
        }
        else cartProductRepository.delete(cartProduct);

        return true;
    }

    @Override
    public boolean removeCart(Cart cart) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        cartProductRepository.deleteProductInCart(userService.findByUsername(authentication.getName()).getId());

        return true;
    }

}