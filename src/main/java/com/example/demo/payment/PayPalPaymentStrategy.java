package com.example.demo.payment;

public class PayPalPaymentStrategy implements PaymentStrategy {
    public String paymentMessage() {
        return "Payed with PayPal";
    }
}
