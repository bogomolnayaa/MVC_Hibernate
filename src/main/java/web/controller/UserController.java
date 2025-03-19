package web.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import web.model.User;
import web.service.UserService;


@Controller
public class UserController {

    private UserService userService;

    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public String showAllUsers(ModelMap model) {
        model.addAttribute("users", userService.getAllUsers());
        return "allUsers";
    }

    @GetMapping("/new")
    public String createUserForm(@ModelAttribute("user") User user) {
        return "saveUser";
    }

    @PostMapping("/userCreate")
    public String addUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "/saveUser";
        }
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/updateUser")
    public String getEditUserForm(Model model, @RequestParam("id") int id) {
        model.addAttribute(userService.getUser(id));
        return "newUser";
    }

    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute("user") @Valid  User user,
                         BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "/saveUser";
        }
        userService.updateUser(user);
        return "redirect:/users";
    }

    @GetMapping("/removeUser")
    public String removeUsers(@RequestParam("id") int id) {
        userService.removeUser(id);
        return "redirect:/users";
    }
}

