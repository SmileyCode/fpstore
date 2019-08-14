package com.example.fpstore.domain;

import javax.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    private User carterId;
    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    private Item itemId;

    public Cart(){}

    public Cart(User carterId, Item itemId)
    {
        this.carterId=carterId;
        this.itemId=itemId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getCarterId() {
        return carterId;
    }

    public void setCarterId(User carterId) {
        this.carterId = carterId;
    }

    public Item getItemId() {
        return itemId;
    }

    public void setItemId(Item itemId) {
        this.itemId = itemId;
    }
}
