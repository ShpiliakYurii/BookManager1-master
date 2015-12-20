package com.springapp.mvc.controller;

import com.springapp.mvc.domain.Role;
import com.springapp.mvc.domain.User;
import com.springapp.mvc.repository.AvtorisationRepository;
import com.springapp.mvc.repository.UserRepository;
import com.springapp.mvc.validation.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yurii on 16.10.2015.
 */
@Controller
public class AdminController {

    private UserRepository userRepository;
    private UserValidator userValidator;

    @Autowired
    public AdminController(UserRepository userRepository, UserValidator userValidator){
        this.userRepository  = userRepository;
        this.userValidator = userValidator;
    }

    @RequestMapping(value = "userList", method = RequestMethod.GET)
    public String userList(Model model){
        List<User> users = this.userRepository.getAll();
        model.addAttribute("users", users);
        return "userList";
    }

    @RequestMapping(value = "removeUser/{id}", method = RequestMethod.GET)
    public String removeUser(@PathVariable Integer id){
        this.userRepository.removeUser(id);
        return "redirect:/userList";
    }

    @RequestMapping(value = "addUser", method = RequestMethod.GET)
    public String addUser(Model model){
        model.addAttribute("user", new User());
        return "addUser";
    }

    @RequestMapping(value = "addUser", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user,BindingResult bindingResult){
        this.userValidator.setUserRepository(userRepository);
        this.userValidator.validate(user,bindingResult);
        if(bindingResult.hasErrors()){
            return "addUser";
        }
        this.userRepository.addUser(user);
        return "redirect:/userList";
    }
}
