package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping()
    public String getUsers(Model model){
        model.addAttribute("users",userService.allUsers());
        return "users/users";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id,Model model){
        model.addAttribute("user",userService.getById(id));
        return "users/show";

    }
    @GetMapping("/add")
    public String add(@ModelAttribute("user") User user){
        return "users/add";

    }
    @PostMapping()
    public String addUser(@ModelAttribute("user") User user){
        userService.addUser(user);
        return "redirect:/users";
    }
    @GetMapping("/{id}/update")
    public String update(Model model, @PathVariable("id") Long id){
        model.addAttribute("user",userService.getById(id));
        return "users/update";
    }
    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user){
        userService.editUser(user);
        return "redirect:/users";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return "redirect:/users";
    }



}