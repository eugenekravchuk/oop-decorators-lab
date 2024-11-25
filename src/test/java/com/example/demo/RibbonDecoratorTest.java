package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.example.demo.decorators.RibbonDecorator;

public class RibbonDecoratorTest {

    @Test
    public void testRibbonDecorator() {
        Item item = new Item();
        item.setPrice(10);
        item.setName("Flower Bouquet");

        RibbonDecorator decoratedItem = new RibbonDecorator(item);
        assertEquals(50, decoratedItem.getPrice(),
         "The decorated price should be 23");

        assertEquals("Ribbon: 40 dollars", 
        decoratedItem.getDescription(), 
        "The description should match the decorator's description");
    }
}