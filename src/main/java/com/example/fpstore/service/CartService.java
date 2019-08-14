package com.example.fpstore.service;

import com.example.fpstore.domain.Cart;
import com.example.fpstore.domain.Item;
import com.example.fpstore.domain.User;
import com.example.fpstore.repos.CartRepo;
import com.example.fpstore.repos.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;

@Service
public class CartService {

    @Autowired
    CartRepo cartRepo;

    @Autowired
    ItemRepo itemRepo;

    public List<Cart> findByCarterId(User id){
        return cartRepo.findByCarterId(id);
    }

    @Transactional
    public void deleteCartById(int id){
        cartRepo.deleteCartById(id);
    }
   //public Cart findByCarterId(Long id){
   //    return cartRepo.findByCarterId(id);
   //}

    //public Item findByCarterId(Long id){
    //    return itemRepo.findById(cartRepo.findByCarterId(id).getItemId());
    //}

    //public List<Integer> findItem(Long id){
    //    return cartRepo.findByCarterId(id).get();
    //}

    //public List<Cart> findByCarterId(Long id){
    //    List<Cart> carts = cartRepo.findByCarterId(id);
    //    List<Integer> itemId = new List<Integer>();
    //    for (Iterator<Cart> i = carts.iterator(); i.hasNext();) {
    //        itemId.add(i.next().getItemId());
    //    }
    //
    //    return cartRepo.findByCarterId(id);
    //}
}
