package ru.kpfu.dm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Denis on 22/03/2016.
 */

@Controller
@RequestMapping("/")
public class PageController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String page(ModelMap model, HttpSession session) {

        return "home";
    }

    @RequestMapping(value = "shipping", method = RequestMethod.GET)
    public String shipping(ModelMap model, HttpServletRequest request) {

        return "shipping";
    }


    @RequestMapping(value = "contacts", method = RequestMethod.GET)
    public String contacts(ModelMap model, HttpSession session) {

        return "contacts";
    }

}
