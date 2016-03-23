package com.controller;

import com.entity.Book;
import com.entity.Role;
import com.entity.User;
import com.service.RoleService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by user on 20.03.2016.
 */

@Controller
public class UserController {

    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;
    /**
     * Цей метод використовуэться для реєстрації користувача з роллю юзер
     */
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String newRegistration(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);
        return "registration";
    }


    @RequestMapping(value = {"/user" }, method = RequestMethod.GET)
    public String listUsers(ModelMap model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user= userService.findByLogin(name);
        Set<Book> books = user.getBooks();
        model.addAttribute("books", books);
        model.addAttribute("user", user);
        return "userPage";
    }
    /*
     * This method will be called on form submission, handling POST request It
     * also validates the user input
     */
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String savedRegistration(@Valid User user,
                                    BindingResult result, ModelMap model) {

        if (result.hasErrors()) {
            System.out.println("There are errors");
            return "registration";
        }
        Set<Role> set =new HashSet<Role>();
        set.add(roleService.findByName("USER"));
        user.setRoles(set);

        userService.save(user);

        System.out.println("First Name : " + user.getName());
        System.out.println("Last Name : "+user.getLastName());
        System.out.println("Login : "+user.getLogin());
        System.out.println("Password : "+user.getPassword());
        System.out.println("Email : "+user.getEmail());
        System.out.println("Phone : "+user.getPhone());
        System.out.println("Checking UsrProfiles....");
        if(user.getRoles()!=null){
            for(Role profile : user.getRoles()){
                System.out.println("Profile : "+ profile.getRoleName());
            }
        }


        model.addAttribute("success", "User " + user.getName() + " has been registered successfully");
        return "registrationsuccess";
    }
}
