package ru.kpfu.dm.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpRequest;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.dm.entity.*;
import ru.kpfu.dm.modul.XMLParser;
import ru.kpfu.dm.repository.CartProductRepository;
import ru.kpfu.dm.service.CartProductService;
import ru.kpfu.dm.service.GroupService;
import ru.kpfu.dm.service.ProductService;
import ru.kpfu.dm.service.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Denis on 22/03/2016.
 */

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartProductService cartProductService;
    @Autowired
    ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public String cart(ModelMap model, HttpSession session, @RequestParam(value = "ajax", required = false, defaultValue = "0") String ajax) {

        Cart cart;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof AnonymousAuthenticationToken) {
            if (session.getAttribute("cart") == null) session.setAttribute("cart", new Cart());
            cart = (Cart) session.getAttribute("cart");
        }
        else cart = cartProductService.getCart();

        model.addAttribute("cart", cart);

        if (ajax.equals("1")) return "ajax/cart_content";
        else return "cart";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addToCart(ModelMap model, @RequestParam(value = "articule", required = true) String articule, HttpSession session) {

        Product product = new Product();
        product.setArticule(articule);
        Cart cart;

        if (session.getAttribute("cart") == null) session.setAttribute("cart", new Cart());


        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication instanceof AnonymousAuthenticationToken) {
            cart = (Cart) session.getAttribute("cart");
            Product product1 = productService.findByArticule(articule);

            cart.addProduct(product1);
            session.setAttribute("cart", cart);
        }
        else {
            cartProductService.addProduct(product);
            cart = cartProductService.getCart();
        }

        model.addAttribute("cart_size", cart.getSize());
        return "ajax/cart_size";
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String removeFromCart(ModelMap model, @RequestParam(value = "articule", required = true) String articule, HttpSession session) {

        Product product = new Product();
        product.setArticule(articule);
        Cart cart;

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof AnonymousAuthenticationToken) {
            cart = (Cart) session.getAttribute("cart");
            Product product1 = productService.findByArticule(articule);
            cart.removeProduct(product1);
            session.setAttribute("cart", cart);
        }
        else {
            cartProductService.removeProduct(product);
            cart = cartProductService.getCart();
        }

        model.addAttribute("cart_size", cart.getSize());
        return "ajax/cart_size";
    }


}
