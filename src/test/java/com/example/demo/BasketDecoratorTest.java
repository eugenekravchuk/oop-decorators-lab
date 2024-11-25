package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.example.demo.decorators.BasketDecorator;

public class BasketDecoratorTest {

    @Test
    public void testBasketDecorator() {
        // Create an Item with a specific price and name
        Item item = new Item();
        item.setPrice(10);
        item.setName("Fruit Basket");

        // Wrap the Item with a BasketDecorator
        BasketDecorator decoratedItem = new BasketDecorator(item);

        // Assert the price is the original item's price plus the decoration cost
        assertEquals(23, decoratedItem.getPrice(), "The decorated price should be 23");

        // Assert the description provided by the decorator
        assertEquals("Basket: 13 dollars", decoratedItem.getDescription(), "The description should match the decorator's description");
    }
}

