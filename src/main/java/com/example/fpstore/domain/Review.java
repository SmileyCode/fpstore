package com.example.fpstore.domain;

import javax.persistence.*;

@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    private User buyerId;
    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    private Item itemId;

    private String revText = null;

    public Review(){}

    public Review(User buyerId, Item itemId)
    {
        this.buyerId=buyerId;
        this.itemId=itemId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(User buyerId) {
        this.buyerId = buyerId;
    }

    public Item getItemId() {
        return itemId;
    }

    public void setItemId(Item itemId) {
        this.itemId = itemId;
    }

    public String getRevText() {
        return revText;
    }

    public void setRevText(String revText) {
        this.revText = revText;
    }
}
