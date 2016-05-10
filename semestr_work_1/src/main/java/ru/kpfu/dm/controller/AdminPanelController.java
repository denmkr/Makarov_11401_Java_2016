package ru.kpfu.dm.controller;

/**
 * Created by Denis on 05.05.16.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.dm.service.OrderService;
import ru.kpfu.dm.service.ProductService;
import ru.kpfu.dm.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminPanelController {

    @Autowired
    OrderService orderService;
    @Autowired
    UserService userService;
    @Autowired
    ProductService productService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String admin() {
        return "admin";
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public String information(ModelMap model) {
        model.addAttribute("orders", orderService.getOrders());
        return "admin/orders";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String users(ModelMap model) {
        model.addAttribute("users", userService.findAll());
        return "admin/users";
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String products(ModelMap model) {
        model.addAttribute("products", productService.findAll());
        return "admin/products";
    }

}