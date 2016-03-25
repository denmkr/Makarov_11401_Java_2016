package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Denis on 22/03/2016.
 */
@Controller
@RequestMapping(value = "/mult/{num1:[0-9]+}/{num2:[0-9]+}")
public class MultController {

    @RequestMapping(method = RequestMethod.GET)
    public String addPage(ModelMap model, @PathVariable String num1, @PathVariable String num2) {
        model.put("result", Integer.parseInt(num1) * Integer.parseInt(num2));
        return "multResult";
    }

}
