package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

/**
 * Created by Denis on 22/03/2016.
 */

@Controller
@RequestMapping("/getdate")
public class DateController {

    @RequestMapping(method = RequestMethod.GET)
    public String getDate(ModelMap model) {
        model.put("date", new Date().toString());
        return "date";
    }
}
