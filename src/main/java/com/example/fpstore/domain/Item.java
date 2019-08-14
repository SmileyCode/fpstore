package com.example.fpstore.domain;

import javax.persistence.*;

@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String itemname;
    private String description;
    private Integer price;
    private String category;
    private Integer discount;

    private String image = "noitem.png";

    @ManyToOne(fetch = FetchType.EAGER)
    private User seller;

    public Item(){}

    public Item(String itemname, String description, Integer price, User seller, String category)
    {
        this.itemname=itemname;
        this.description=description;
        this.price=price;
        this.seller=seller;
        this.category=category;
        this.discount=0;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSellerName(){
        return seller != null ? seller.getUsername() : "No seller";
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
