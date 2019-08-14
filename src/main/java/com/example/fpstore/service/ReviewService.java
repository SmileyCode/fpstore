package com.example.fpstore.service;

import com.example.fpstore.domain.Item;
import com.example.fpstore.domain.Review;
import com.example.fpstore.domain.User;
import com.example.fpstore.repos.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    ReviewRepo reviewRepo;

    public List<Review> findByItemId(Item id){
        return reviewRepo.findByItemIdAndRevTextNotNull(id);
    }

    public Review findByItemIdAndBuyerId(Item itemId, User buyerId){
        return reviewRepo.findByItemIdAndBuyerId(itemId, buyerId);
    }
}
