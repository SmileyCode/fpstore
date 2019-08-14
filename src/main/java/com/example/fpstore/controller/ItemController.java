package com.example.fpstore.controller;

import com.example.fpstore.domain.*;
import com.example.fpstore.repos.CartRepo;
import com.example.fpstore.repos.ItemRepo;
import com.example.fpstore.repos.ReviewRepo;
import com.example.fpstore.service.CartService;
import com.example.fpstore.service.ItemService;
import com.example.fpstore.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
public class ItemController {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private CartRepo cartRepo;

    @Autowired
    private ReviewRepo reviewRepo;

    @Autowired
    CartService cartService;

    @Autowired
    ItemService itemService;

    @Autowired
    ReviewService reviewService;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/additem")
    public String additem(Map<String, Object> model) {
        return "additem";
    }

    @PostMapping("/additem")
    public String main(@RequestParam String itemname, @RequestParam String description, @RequestParam Integer price, @AuthenticationPrincipal UserDetailsImpl seller, @RequestParam String category, Map<String, Object> model) {
        Item item = new Item(itemname, description, price, seller.getUser(), category);
        itemRepo.save(item);
        return "additem";
    }


    @GetMapping("/cart")
    public String cart(@AuthenticationPrincipal UserDetailsImpl carter, Map<String, Object> model) {
        //Iterable<Item> itemk = itemService.findById(cartService.findItem(carter.getUser().getId()));
        //Iterable<Item> iteml = cartService.findByCarterId((long) 22);
                //Iterable<Cart> iteml = cartService.findByCarterId(carter.getUser().getId());
        //Item itemg = cartService.findByCarterId(carter.getUser().getId());
        //Item itemg = itemService.findById(cartRepo.findByCarterId(carter.getUser().getId()).getItemId());
        //Iterable<Item> items = itemService.findById();
        //Iterable<Item> items = itemRepo.findAll();
        //model.put("items", itemk);

        //int test = cartService.findItem(carter.getUser().getId());

        Iterable<Cart> carts = cartService.findByCarterId(carter.getUser());

        model.put("carts", carts);
        return "cart";
    }

    @PostMapping("cart/delete")//cart
    public String delete(@RequestParam int id, Map<String, Object> model) {
        cartService.deleteCartById(id);
        return "redirect:/cart";
    }

    @PostMapping("cart/buy")
    public String buy(@AuthenticationPrincipal UserDetailsImpl buyer, @RequestParam int itemId, @RequestParam int id,Map<String, Object> model) {
        Review review = new Review(buyer.getUser(), itemService.findById(itemId));
        reviewRepo.save(review);
        cartService.deleteCartById(id);
        return "redirect:/";
    }

    @GetMapping("/item")
    public String viewitem(@AuthenticationPrincipal UserDetailsImpl buyer, @RequestParam int id, Map<String, Object> model) {

        Item item = itemService.findById(id);
        model.put("item", item);

        if(item.getSeller().getId() == buyer.getUser().getId())
        {
            model.put("message", "[Редактировать]");
        }

        Iterable<Review> reviews = reviewService.findByItemId(item);
        model.put("reviews", reviews);

        Review addNewReview = reviewService.findByItemIdAndBuyerId(item, buyer.getUser());
        model.put("addNewReview", addNewReview);
        return "item";
    }

    @PostMapping("/item/addreview")
    public String addReview(@AuthenticationPrincipal UserDetailsImpl buyer, @RequestParam int itemId, @RequestParam String revText, Map<String, Object> model) {
        Review review = reviewService.findByItemIdAndBuyerId(itemService.findById(itemId), buyer.getUser());
        review.setRevText(revText);
        reviewRepo.save(review);
        return "redirect:/";
    }

    @PostMapping(value = "/item")
    public String addToCart(@RequestParam int id, @AuthenticationPrincipal UserDetailsImpl carter){
        Cart cart = new Cart(carter.getUser(), itemService.findById(id));
        cartRepo.save(cart);
        return "redirect:/cart";
    }

    @GetMapping(value = "/item/edit")
    public String editItem(@RequestParam int id, Map<String, Object> model){
            Item item = itemService.findById(id);
            model.put("item", item);
        return "itemEdit";
    }

    @PostMapping(value = "/item/edit")
    public String editItem(@AuthenticationPrincipal UserDetailsImpl seller, @RequestParam("file") MultipartFile file, @RequestParam int id, String itemname, String description, Integer price, String category, Map<String, Object> model) throws IOException {
        Item item = itemService.findById(id);
        if(item.getSeller().getId() == seller.getUser().getId())
        {
            item.setItemname(itemname);
            item.setCategory(category);
            item.setDescription(description);
            item.setPrice(price);

            if (file != null && !file.getOriginalFilename().isEmpty()) {
                File uploadDir = new File(uploadPath);

                if (!uploadDir.exists()) {
                    uploadDir.mkdir();
                }

                String uuidFile = UUID.randomUUID().toString();
                String resultFilename = uuidFile + "." + file.getOriginalFilename();

                file.transferTo(new File(uploadPath + "/" + resultFilename));

                item.setImage(resultFilename);
            }

            itemService.update(item);
        }
        return "redirect:/item?id=" + item.getId();
    }


    @PostMapping(value = "/discount")
    public String editDiscount(@AuthenticationPrincipal UserDetailsImpl seller, @RequestParam int id, int discount, Map<String, Object> model){
        Item item = itemService.findById(id);
        if(item.getSeller().getId() == seller.getUser().getId())
        {
            item.setDiscount(discount);
            itemService.update(item);
        }
        return "redirect:/item?id=" + item.getId();
    }
}
