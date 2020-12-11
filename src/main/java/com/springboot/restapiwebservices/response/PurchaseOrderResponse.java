package com.springboot.restapiwebservices.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class PurchaseOrderResponse {

    private int purchaseOrderId;
    private boolean purchaseOrderIdDeleted;
    //String PurchaseOrderIdNotFound="Not_Found or Already Deleted";
    public PurchaseOrderResponse(int purchaseOrderId, boolean purchaseOrderIdDeleted){
        this.purchaseOrderId =purchaseOrderId;
        this.purchaseOrderIdDeleted = purchaseOrderIdDeleted;
    }

    public int getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(int purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }

    public boolean getPurchaseOrderIdDeleted() {
        return purchaseOrderIdDeleted;
    }

    public void setPurchaseOrderIdDeleted(boolean purchaseOrderIdDeleted) {
        this.purchaseOrderIdDeleted = purchaseOrderIdDeleted;
    }

//    public String getPurchaseOrderIdNotFound() {
//        return PurchaseOrderIdNotFound;
//    }
//
//    public void setPurchaseOrderIdNotFound(String purchaseOrderIdNotFound) {
//        PurchaseOrderIdNotFound = purchaseOrderIdNotFound;
//    }
}
