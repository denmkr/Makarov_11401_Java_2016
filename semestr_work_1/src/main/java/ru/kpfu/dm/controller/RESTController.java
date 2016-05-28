package ru.kpfu.dm.controller;

/**
 * Created by Denis on 05.05.16.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.dm.entity.User;
import ru.kpfu.dm.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/api")
public class RESTController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public @ResponseBody
    List<User> getAllUsers() {
        return userService.findAll();
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public @ResponseBody
    User signin(@RequestParam("username") String username, @RequestParam("password") String password) {
        System.out.println(username + " " + password);
        User user = userService.findByUsername(username);

        BCryptPasswordEncoder bcryptEncoder = new BCryptPasswordEncoder(12);
        password = bcryptEncoder.encode(password);

        if (user != null) {
            if (!user.getPassword().equals(password))
                user = null;
        }
        else user = null;

        return user;
    }


}