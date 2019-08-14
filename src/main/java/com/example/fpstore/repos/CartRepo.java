package com.example.fpstore.repos;

import com.example.fpstore.domain.Cart;
import com.example.fpstore.domain.Item;
import com.example.fpstore.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepo extends JpaRepository<Cart, Long> {
    List<Cart> findByCarterId(User carterId);

    void deleteCartById(int id);
}
