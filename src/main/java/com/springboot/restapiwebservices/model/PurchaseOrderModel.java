package com.springboot.restapiwebservices.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "purchase_order")
public class PurchaseOrderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int purchaseOrderId;
    private int projectId;
    private long orderNumber;
    private Date orderDate;
    private Date orderValidTillDate;


    public PurchaseOrderModel() {
    }

    public PurchaseOrderModel(int purchaseOrderId, int projectId, long orderNumber, Date orderDate, Date orderValidTillDate) {
        this.purchaseOrderId = purchaseOrderId;
        this.projectId = projectId;
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.orderValidTillDate = orderValidTillDate;
    }

    public int getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(int purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getOrderValidTillDate() {
        return orderValidTillDate;
    }

    public void setOrderValidTillDate(Date orderValidTillDate) {
        this.orderValidTillDate = orderValidTillDate;
    }

    @Override
    public String toString() {
        return "PurchaseOrderModel{" +
                "purchaseOrderId=" + purchaseOrderId +
                ", projectId=" + projectId +
                ", orderNumber=" + orderNumber +
                ", orderDate=" + orderDate +
                ", orderValidTillDate=" + orderValidTillDate +
                '}';
    }
}
