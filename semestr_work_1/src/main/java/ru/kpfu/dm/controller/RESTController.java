package ru.kpfu.dm.controller;

/**
 * Created by Denis on 05.05.16.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.dm.entity.Order;
import ru.kpfu.dm.entity.Product;
import ru.kpfu.dm.entity.ProductGroup;
import ru.kpfu.dm.entity.User;
import ru.kpfu.dm.service.OrderService;
import ru.kpfu.dm.service.ProductService;
import ru.kpfu.dm.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/api")
public class RESTController {

    @Autowired
    UserService userService;
    @Autowired
    ProductService productService;
    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public @ResponseBody
    List<User> getAllUsers() {
        return userService.findAll();
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public @ResponseBody
    List<Order> getAllOrders() {
        List<Order> orders = orderService.getOrders();

        for (Order order : orders) {
            order.getProduct().getProductGroup().setChildGroups(null);
            order.getProduct().getProductGroup().setParentGroup(null);
        }

        return orders;
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public @ResponseBody
    List<Product> getAllProducts() {
        List<Product> products = productService.findAll();

        for (Product product : products) {
            product.getProductGroup().setChildGroups(null);
            product.getProductGroup().setParentGroup(null);
        }

        return products;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody
    User signin(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {

        User user = userService.findByUsername(username);

        if (user != null) {
            BCryptPasswordEncoder bcryptEncoder = new BCryptPasswordEncoder(12);
            bcryptEncoder.encode(password);

            if (bcryptEncoder.matches(password, user.getPassword())){
                return user;
            }
        }

        return null;

    }


}