package ru.kpfu.dm.controller;

/**
 * Created by Denis on 05.05.16.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String orders(ModelMap model) {
        model.addAttribute("orders", orderService.getOrders());
        return "admin/orders";
    }

    @RequestMapping(value = "/orders", method = RequestMethod.POST)
    public String ordersAjax(ModelMap model) {
        model.addAttribute("orders", orderService.getOrders());
        return "admin/ajax/orders_content";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String users(ModelMap model) {
        model.addAttribute("users", userService.findAll());
        return "admin/users";
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String usersAjax(ModelMap model) {
        model.addAttribute("users", userService.findAll());
        return "admin/ajax/users_content";
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String products(ModelMap model) {
        model.addAttribute("products", productService.findAll());
        return "admin/products";
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public String productsAjax(ModelMap model) {
        model.addAttribute("products", productService.findAll());
        return "admin/ajax/products_content";
    }

    @RequestMapping(value = "/products/remove", method = RequestMethod.POST)
    public String addProduct(ModelMap model, @RequestParam(value = "articule", required = true) String articule) {
        productService.delete(productService.findByArticule(articule).getId());
        model.addAttribute("products", productService.findAll());
        return "admin/ajax/products_content";
    }

    @RequestMapping(value = "/products/upload", method = RequestMethod.GET)
    public String updateProduct(ModelMap model) {
        return "admin/ajax/products_upload";
    }

    @RequestMapping(value = "/products/upload", method = RequestMethod.POST)
    public String updateProductAjax(ModelMap model) {
        return "admin/ajax/products_upload_content";
    }

    @RequestMapping(value = "/information", method = RequestMethod.GET)
    public String information(ModelMap model) {
        model.addAttribute("users_count", userService.countOfUsers());
        model.addAttribute("orders_count", orderService.countOfOrdersToday());
        return "admin/information";
    }

    @RequestMapping(value = "/information", method = RequestMethod.POST)
    public String informationAjax(ModelMap model) {
        model.addAttribute("users_count", userService.countOfUsers());
        model.addAttribute("orders_count", orderService.countOfOrdersToday());

        return "admin/ajax/information_content";
    }


}

