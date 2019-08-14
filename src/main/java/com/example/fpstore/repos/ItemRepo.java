package com.example.fpstore.repos;

import com.example.fpstore.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepo extends JpaRepository<Item, Long> {
    Item findById(int id);

    List<Item> findByItemnameContaining(String itemname);

    List<Item> findByItemnameContainingAndDiscountGreaterThan(String itemname, int discount);

    List<Item> findByCategory(String category);
}
