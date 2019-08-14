package com.example.fpstore.controller;


import com.example.fpstore.domain.Role;
import com.example.fpstore.domain.User;
import com.example.fpstore.repos.UserRepo;
import com.example.fpstore.service.MailService;
import com.example.fpstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;
import java.util.UUID;

@Controller
public class SecurityController {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    UserService service;

    @Autowired
    MailService sender;

    @GetMapping(value = "/registration")
    public String  getUser(Model model){
        model.addAttribute("newUser", new User());
        return "registration";
    }

    @PostMapping(value = "/registration")
    public String setUser(@ModelAttribute User user, Map<String, Object> model){
        User userFromDb = service.findByMail(user.getMail());

        if (userFromDb != null) {
            model.put("message", "E-mail уже зарегестрирован!");
            return "registration";
        }
        user.setActivationCode(UUID.randomUUID().toString());
        service.addUser(user);
        return "login";
    }

    @GetMapping(value = "/activate/{code}")
    public String activate(@PathVariable String code){
        service.activateUser(code);
        return "login";
    }

    @GetMapping("/forgot")
    public String getForgotPage(){
        return "forgotPassword";
    }

    @PostMapping("/forgot")
    public String getForgotMail(@RequestParam String email){
        User user = service.findByMail(email);
        user.setActivationCode(UUID.randomUUID().toString());
        service.update(user);
        String message = String.format(
                "Hello there! You've(or not you) just send us a request for your password \n" +
                        "visit next link to enter new password \n" +
                        " http://localhost:8080/forgot/%s" +
                        " if it wasn't just ignore this message \n" +
                        "Good luck",
                user.getActivationCode()
        );
        sender.send(email, "Forgot your password", message);
        return "redirect:/";
    }

    @GetMapping("/forgot/{code}")
    public String getPasswordChangePage(@PathVariable String code,
                                        Model model){
        model.addAttribute("code",code);
        return "newPassword";
    }

    @PostMapping("/forgot/{code}")
    public String setNewPass(@PathVariable String code,
                             @RequestParam String password,
                             @RequestParam String hash){
        User user = service.findByActivationCode(hash);
        user.setPassword(password);
        service.update(user);
        return "redirect:/";
    }
}