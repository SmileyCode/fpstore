package com.example.fpstore.controller;


import com.example.fpstore.domain.Item;
import com.example.fpstore.repos.ItemRepo;
import com.example.fpstore.repos.ReviewRepo;
import com.example.fpstore.repos.UserRepo;
import com.example.fpstore.service.ItemService;
import com.example.fpstore.service.ReviewService;
import com.example.fpstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ReviewRepo reviewRepo;

    @GetMapping("/")
    public String main(Map<String, Object> model) {
        Iterable<Item> items = itemRepo.findAll();//.subList(0,6)
        model.put("items", items);
        model.put("itemCount",itemRepo.count());
        model.put("userCount",userRepo.count());
        model.put("reviewCount",reviewRepo.count());
        return "main";
    }
}