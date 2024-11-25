package com.example.demo.delivery;

public class PostDeliveryStrategy implements Delivery {
    public String getDeliveryNotification() {
        return "Delivery with simple Post";
    }

}
