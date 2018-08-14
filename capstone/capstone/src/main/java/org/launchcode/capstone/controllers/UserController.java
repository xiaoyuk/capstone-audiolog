package org.launchcode.capstone.controllers;

import org.launchcode.capstone.models.User;

import org.launchcode.capstone.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserDao userDao;


    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("users", userDao.findAll());
        model.addAttribute("title", "All Users");

        return "user/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {

        model.addAttribute(new User());
        model.addAttribute("title", "User Signup");

        return "user/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute User user, String verify) {
        if(verify.equals(user.getPassword())) {
            model.addAttribute("user", user);
            userDao.save(user);
            return "redirect:";
        } else {
            model.addAttribute("username", user.getUsername());
            model.addAttribute("email", user.getEmail());
            model.addAttribute("title", "User Signup");
            model.addAttribute("message", "Passwords do not match");
            return "user/add";
        }
    }
}

