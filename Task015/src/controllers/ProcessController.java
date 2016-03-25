package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Alexander on 01/10/2015.
 */

@Controller
@RequestMapping(value = "/process")
public class ProcessController {

    @RequestMapping(method = RequestMethod.GET)
    public String processPage() {
        return "process";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String toResultPage(@RequestParam(name="operat") String operation, @RequestParam(name="text") String text, RedirectAttributes redirectAttributes) {
        int result = 0;

        if (operation.equals("symbols")) result = text.length();
        if (operation.equals("words")) result = (text.split(" ")).length;
        if (operation.equals("paragraphs")) result = (text.split("\\n")).length;
        if (operation.equals("sentences")) {
            Pattern pattern = Pattern.compile("[\\.!?]+");
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                result++;
            }
        }

        redirectAttributes.addFlashAttribute("result", result);
        return "redirect:/result";

    }


}
