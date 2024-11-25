package com.example.demo.payment;

public class CreditCardPaymentStrategy implements PaymentStrategy {
    public String paymentMessage() {
        return "Payed with card";
    }
}
