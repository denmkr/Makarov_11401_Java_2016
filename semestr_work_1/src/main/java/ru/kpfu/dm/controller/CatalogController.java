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
@RequestMapping("/")
public class CatalogController {

    @Autowired
    ProductService productService;
    @Autowired
    GroupService groupService;
    @Autowired
    UserService userService;

    @RequestMapping(value = "catalog", method = RequestMethod.GET)
    public String catalog(ModelMap model) {
        return "redirect:/catalog/page/1";
    }

    @RequestMapping(value = "catalog/page/{page}", method = RequestMethod.GET)
    public String pageCatalog(ModelMap model, @RequestParam(value = "stock", required = false, defaultValue = "off") String stock,
                       @RequestParam(value = "sort", required = false, defaultValue = "name_ASC") String sort,
                       @RequestParam(value = "group", required = false, defaultValue = "0") String group,
                       @RequestParam(value = "search", required = false, defaultValue = "") String search,
                       @RequestParam(value = "ajax", required = false, defaultValue = "0") String ajax, @PathVariable(value = "page") int page) {

        Page<Product> products = productService.findAll(page, stock, search, sort);

        int current = products.getNumber() + 1;
        int begin = Math.max(1, current - 3);
        int end = Math.min(begin + 5, products.getTotalPages());

        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);

        model.addAttribute("products", products);

        if (ajax.equals("1")) return "ajax/catalog_content_test";
        else return "catalog";
    }

}
