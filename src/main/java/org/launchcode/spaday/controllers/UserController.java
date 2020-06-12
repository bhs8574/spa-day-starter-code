package org.launchcode.spaday.controllers;

import org.launchcode.spaday.data.UserData;
import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping
    public String displayAllUsers(Model model) {
        model.addAttribute("users", UserData.getAll());
        return "user/index";
    }

    @RequestMapping("add")
    public String displayAddUserForm() {
        return "user/add";
    }

    @PostMapping
    public String processAddUserForm(@ModelAttribute User newUser, Model model, String verify) {
        if (newUser.getPassword().equals(verify)) {
            UserData.add(newUser);
            return "redirect:user";
        } else {
            model.addAttribute("error", true);
            model.addAttribute("username", newUser.getUsername());
            model.addAttribute("email", newUser.getEmail());
            return "user/add";
        }
    }

    @GetMapping("details/{id}")
    public String displayUserInfo(Model model, @PathVariable int id) {
        if (UserData.getById(id) != null & id > 0) {
            model.addAttribute("user", UserData.getById(id));
        } else {
            model.addAttribute("invalidUserId", true);
        }
        return "user/details";
    }

}
