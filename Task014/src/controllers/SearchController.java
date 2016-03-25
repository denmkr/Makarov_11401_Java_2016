package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Denis on 22/03/2016.
 */

@Controller
@RequestMapping(value = "/{address:yahoo|bing|baidu|aol}/{search:.*}")
public class SearchController {

    @RequestMapping(method = RequestMethod.GET)
    public String getSearch(ModelMap model, @PathVariable String address, @PathVariable String search) {
        String action = "";
        String name = "";

        if (address.equals("baidu")) {
            action = "http://www.baidu.com/s";
            name = "wd";
        }
        if (address.equals("bing")) {
            action="http://www.bing.com/search";
            name = "q";
        }
        if (address.equals("yahoo")) {
            action="https://search.yahoo.com/search";
            name = "p";
        }
        if (address.equals("aol")) {
            action="http://search.aol.com/search";
            name = "q";
        }

        model.put("address", address);
        model.put("action", action);
        model.put("search", search);
        model.put("name", name);

        return "search";
    }

}
