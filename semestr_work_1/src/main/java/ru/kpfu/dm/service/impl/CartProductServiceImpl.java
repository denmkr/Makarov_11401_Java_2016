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
    CartProductRepository cartProductRepository;
    @Autowired
    UserService userService;
    @Autowired
    ProductService productService;

    @Override
    @Transactional
    public boolean addProduct(Product product) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CartProduct cartProduct = new CartProduct();

        if (cartProductRepository.findByUserIdAndProductId(userService.findByUsername(authentication.getName()).getId(), productService.findByArticule(product.getArticule()).getId()) != null) {
            cartProductRepository.updateProductInCart(2 , userService.findByUsername(authentication.getName()).getId(), productService.findByArticule(product.getArticule()).getId());
        }
        else {
            cartProduct.setProductId(productService.findByArticule(product.getArticule()).getId());
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
        Product product;
        for (CartProduct cartProduct: cartProducts) {
            for (int i=1; i<=cartProduct.getCount(); i++) {
                product = productService.findById(cartProduct.getProductId());
                cart.addProduct(product);
            }
        }

        return cart;
    }

    @Override
    @Transactional
    public void removeProduct(Product product) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CartProduct cartProduct = cartProductRepository.findByUserIdAndProductId(userService.findByUsername(authentication.getName()).getId(), productService.findByArticule(product.getArticule()).getId());

        if (cartProduct.getCount() > 1) cartProductRepository.updateProductInCart(1 , userService.findByUsername(authentication.getName()).getId(), productService.findByArticule(product.getArticule()).getId());
        else cartProductRepository.delete(cartProduct);


    }

    @Override
    public void removeCart(Cart cart) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        cartProductRepository.deleteProductInCart(userService.findByUsername(authentication.getName()).getId());
    }

}