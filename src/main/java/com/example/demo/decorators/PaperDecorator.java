package com.example.demo.decorators;

import com.example.demo.Item;

public class PaperDecorator implements ItemDecorator{
    Item item;
    
    public PaperDecorator(Item item) {
        this.item = item;
    }

    public int getPrice() {
        return 4 + item.getPrice();
    }

    public String getDescription(){
        return "Paper: 4 dollars";
    }    
}
