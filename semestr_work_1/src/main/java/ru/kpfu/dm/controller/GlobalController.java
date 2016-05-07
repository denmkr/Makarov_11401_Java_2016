package ru.kpfu.dm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.dm.entity.Cart;
import ru.kpfu.dm.service.CartProductService;

import javax.servlet.http.HttpSession;


/**
 * Created by Denis on 22/03/2016.
 */

@ControllerAdvice
public final class GlobalController {

    @Autowired
    CartProductService cartProductService;

    @ModelAttribute("username")
    public String getUsername(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String username = authentication.getName();
            return username;
        }
        return null;
    }

    @ModelAttribute
    public void getCartSize(HttpSession session, ModelMap model) {
        Cart cart;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof AnonymousAuthenticationToken) {
            if (session.getAttribute("cart") == null) session.setAttribute("cart", new Cart());
            cart = (Cart) session.getAttribute("cart");
        }
        else cart = cartProductService.getCart();

        model.addAttribute("cart_size", cart.getSize());
    }

}
