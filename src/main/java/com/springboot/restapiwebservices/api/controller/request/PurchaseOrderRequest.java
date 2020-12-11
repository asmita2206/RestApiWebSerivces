package com.springboot.restapiwebservices.api.controller.request;

import java.util.Date;

public class PurchaseOrderRequest {

    long orderNumber;
    Date orderDate;
    Date orderValidTillDate;

    public long getOrderNumber() {
        return orderNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public Date getOrderValidTillDate() {
        return orderValidTillDate;
    }
}
