package com.example.fpstore.controller;

import com.example.fpstore.domain.User;
import com.example.fpstore.domain.UserDetailsImpl;
import com.example.fpstore.repos.UserRepo;
import com.example.fpstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    UserService userService;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping(value = "/profile")
    public String profile(Model model,
                          @AuthenticationPrincipal UserDetailsImpl userDetails){
        model.addAttribute("loggedInUser", userDetails);
        return "profile";
    }

    @GetMapping(value = "/profile/edit")
    public String editProfile(Model model,
                          @AuthenticationPrincipal UserDetailsImpl userDetails){
        model.addAttribute("loggedInUser", userDetails);
        return "profileEdit";
    }


    @PostMapping("/profile/edit")
    public String editProfile(@RequestParam String username, String realname, String surname, String addname, String postcode, String adress, String city, String country, String phonenumber, String password,
                              @AuthenticationPrincipal UserDetailsImpl userDetails){
        User user = userDetails.user;
        user.setUsername(username);
        user.setRealname(realname);
        user.setSurname(surname);
        user.setAddname(addname);
        user.setPostcode(postcode);
        user.setAdress(adress);
        user.setCity(city);
        user.setCountry(country);
        user.setPhonenumber(phonenumber);
        user.setPassword(password);;
        userService.update(user);
        return "redirect:/profile";
    }

    @GetMapping("/addavatar")
    public String addAvatar(){
        return "addAvatar";
    }

    @PostMapping("/addavatar")
    public String addUserAvatar(@RequestParam("file") MultipartFile file, @AuthenticationPrincipal UserDetailsImpl userDetails) throws IOException {

        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFilename));

            User user = userDetails.getUser();
            user.setAvatar(resultFilename);
            userService.update(user);
        }

        return "redirect:/profile";
    }

}
