package com.springboot.restapiwebservices.service;

import com.springboot.restapiwebservices.model.PurchaseOrderModel;
import com.springboot.restapiwebservices.repository.PurchaseOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseOrderService {

    PurchaseOrderRepo purchaseOrderRepo;

    public List<PurchaseOrderModel> getOrderBy(int projectId) {
        List<PurchaseOrderModel> purchaseOrderModels=purchaseOrderRepo.findByProjectId(projectId);

        if(!purchaseOrderModels.isEmpty())
            return purchaseOrderModels;
        else
            ResponseEntity.status(HttpStatus.NOT_FOUND);
            return purchaseOrderModels;
    }

    public ResponseEntity<PurchaseOrderModel> getOrderById(int purchaseOrderId) {

       PurchaseOrderModel purchaseOrderModel=purchaseOrderRepo.findByPurchaseOrderId(purchaseOrderId);

        if(purchaseOrderModel!=null)
            return new ResponseEntity(purchaseOrderModel,HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
