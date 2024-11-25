package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.example.demo.decorators.PaperDecorator;

public class PaperDecoratorTest {

    @Test
    public void testPaperDecorator() {
        Item item = new Item();
        item.setPrice(10);
        item.setName("Gift Item");

        PaperDecorator decoratedItem = new PaperDecorator(item);

        assertEquals(14, decoratedItem.getPrice(), "The decorated price should be 23");

        assertEquals("Paper: 4 dollars", decoratedItem.getDescription(), "The description should match the decorator's description");
    }
}
