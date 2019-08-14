package com.example.fpstore.repos;

import com.example.fpstore.domain.Item;
import com.example.fpstore.domain.Review;
import com.example.fpstore.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Long> {

    List<Review> findByItemIdAndRevTextNotNull(Item itemId);

    Review findByItemIdAndBuyerId(Item itemId, User buyerId);
}
