package ru.kpfu.dm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.dm.modul.XMLParser;
import ru.kpfu.dm.service.GroupService;
import ru.kpfu.dm.service.ProductService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Denis on 22/03/2016.
 */

@Controller
@RequestMapping("/")
public class UpdateDataController {

    @Autowired
    ProductService productService;
    @Autowired
    GroupService groupService;

    @RequestMapping(value = "database", method = RequestMethod.GET)
    public String database(ModelMap model, HttpServletRequest request) {

        return "database";
    }

    @RequestMapping(value = "admin/products/update", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public @ResponseBody String completeData(ModelMap model, HttpServletRequest request) {
        XMLParser parser = new XMLParser(request);

        groupService.updateGroups(parser.getProductGroups());
        productService.updateProducts(parser.getProducts());
        groupService.addParentsGroupsToGroups(parser.getRelations());

        return "Ваши товары обновлены";
    }

}
