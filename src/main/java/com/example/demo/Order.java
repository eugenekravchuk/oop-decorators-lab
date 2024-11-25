package com.example.demo;

import java.util.List;

import com.example.demo.delivery.Delivery;
import com.example.demo.payment.PaymentStrategy;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Order {

    private List<Item> items;
    private Delivery delivery;
    private PaymentStrategy payment;

    public Order(List<Item> items, Delivery delivery, PaymentStrategy payment) {
        this.items = items;
        this.delivery = delivery;
        this.payment = payment;
    }
}
