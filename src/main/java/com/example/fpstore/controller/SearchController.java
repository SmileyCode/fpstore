package com.example.fpstore.controller;

import com.example.fpstore.domain.Item;
import com.example.fpstore.repos.ItemRepo;
import com.example.fpstore.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class SearchController {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    ItemService itemService;

    @GetMapping("/search")
    public String searchitem(@RequestParam String search, Map<String, Object> model) {

        Iterable<Item> items = itemService.findByItemname(search);
        model.put("items", items);

        return "search";
    }

    @GetMapping("/category")
    public String searchCategory(@RequestParam String category, Map<String, Object> model) {

        Iterable<Item> items = itemService.findByCategory(category);
        model.put("items", items);

        return "search";
    }


    @GetMapping("/advsearch")
    public String advSearchItemGet(@RequestParam String search, boolean discountOnly, Map<String, Object> model) {

        int discount=-1;
        if(discountOnly) {
            discount=1;
        }
        Iterable<Item> items = itemService.findByItemnameAndDiscount(search, discount);
        model.put("items", items);

        return "search";
    }

}
