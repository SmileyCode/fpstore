package com.example.fpstore.service;

import com.example.fpstore.domain.Item;
import com.example.fpstore.repos.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ItemService {
    @Autowired
    ItemRepo itemRepo;

    public Item findById(int id){
        return itemRepo.findById(id);
    }

    public List<Item> findByItemname(String itemname){
        return itemRepo.findByItemnameContaining(itemname);
    }

    public List<Item> findByItemnameAndDiscount(String itemname, int discount){
        return itemRepo.findByItemnameContainingAndDiscountGreaterThan(itemname,discount);
    }

    public List<Item> findByCategory(String category){
        return itemRepo.findByCategory(category);
    }

    public void update(Item item){
        itemRepo.save(item);
    }

    //public List<Item> findListById(int id){
    //    List<Item> list = itemRepo.findById(id);
    //    return list;
    //}
}
