package com.example.demo.decorators;

import com.example.demo.Item;

public class BasketDecorator implements ItemDecorator{
    Item item;
    
    public BasketDecorator(Item item) {
        this.item = item;
    }

    public int getPrice() {
        return 13 + item.getPrice();
    }

    public String getDescription(){
        return "Basket: 13 dollars";
    }    
}
