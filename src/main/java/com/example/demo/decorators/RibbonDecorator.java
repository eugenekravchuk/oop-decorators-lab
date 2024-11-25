package com.example.demo.decorators;

import com.example.demo.Item;

public class RibbonDecorator implements ItemDecorator{
    Item item;
    
    public RibbonDecorator(Item item) {
        this.item = item;
    }

    public int getPrice() {
        return 40 + item.getPrice();
    }

    public String getDescription(){
        return "Ribbon: 40 dollars";
    }    
}
