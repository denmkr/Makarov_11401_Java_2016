package ru.kpfu.dm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.dm.entity.Product;
import ru.kpfu.dm.service.GroupService;
import ru.kpfu.dm.service.ProductService;
import ru.kpfu.dm.service.UserService;

/**
 * Created by Denis on 22/03/2016.
 */

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/product/{articule}", method = RequestMethod.GET)
    public String pageCatalog(ModelMap model, @PathVariable(value = "articule") String articule) {
        Product product = productService.findByArticule(articule);
        model.addAttribute("product", product);

        return "product";
    }

}
