package ru.kpfu.dm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.dm.entity.SignUpForm;
import ru.kpfu.dm.entity.User;
import ru.kpfu.dm.service.UserRoleService;
import ru.kpfu.dm.service.UserService;

import javax.validation.Valid;

/**
 * Created by Denis on 25.04.16.
 */

@Controller
public class SignUpController {
    @Autowired
    UserService userService;
    @Autowired
    UserRoleService userRoleService;

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signupPage(ModelMap model) {

        model.addAttribute("signup_form", new SignUpForm());
        return "signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signup(@ModelAttribute("signup_form") @Valid SignUpForm form, BindingResult result) {
        User user = new User();
        user.setUsername(form.getUsername());
        user.setEmail(form.getEmail());
        user.setPassword(form.getPassword());

        userService.create(user);
        userRoleService.createUser(user);

        return "redirect:/signup_success";
    }

    @RequestMapping(value = "/signup_success", method = RequestMethod.GET)
    public String signupSuccess() {
        return "signup_success";
    }
}

