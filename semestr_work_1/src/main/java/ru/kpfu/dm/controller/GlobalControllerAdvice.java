package ru.kpfu.dm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.dm.entity.Cart;
import ru.kpfu.dm.entity.CartSize;
import ru.kpfu.dm.entity.User;
import ru.kpfu.dm.service.CartProductService;

import javax.servlet.http.HttpSession;
import java.security.Principal;


/**
 * Created by Denis on 22/03/2016.
 */

@ControllerAdvice
public final class GlobalControllerAdvice {

    @Autowired
    CartProductService cartProductService;

    @ModelAttribute("username")
    public User getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = new User();
        user.setUsername(authentication.getName());
        return user;
    }

    @ModelAttribute
    public void getCart(HttpSession session, ModelMap model) {
        Cart cart;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof AnonymousAuthenticationToken) {
            if (session.getAttribute("cart") == null) session.setAttribute("cart", new Cart());
            cart = (Cart) session.getAttribute("cart");
        }
        else cart = cartProductService.getCart();
        CartSize size = new CartSize();
        size.setSize(cart.getSize());

        model.addAttribute("cart_size", size);
    }


}
