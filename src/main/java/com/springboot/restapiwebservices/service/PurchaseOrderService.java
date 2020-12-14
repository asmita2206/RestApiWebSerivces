package com.springboot.restapiwebservices.service;

import com.springboot.restapiwebservices.constants.StringConstants;
import com.springboot.restapiwebservices.exception.NoRecordFoundException;
import com.springboot.restapiwebservices.model.PurchaseOrderModel;
import com.springboot.restapiwebservices.repository.PurchaseOrderRepo;
import com.springboot.restapiwebservices.api.controller.request.PurchaseOrderRequest;
import com.springboot.restapiwebservices.response.PurchaseOrderResponse;
import com.springboot.restapiwebservices.utils.ProjectDetailsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseOrderService {

    @Autowired
    PurchaseOrderRepo purchaseOrderRepo;

   /* public List<PurchaseOrderModel> getOrderBy(String projectId) {
        List<PurchaseOrderModel> purchaseOrderModels=purchaseOrderRepo.findByProjectId(projectId);

        if(!purchaseOrderModels.isEmpty())
            return purchaseOrderModels;
        else
            ResponseEntity.status(HttpStatus.NOT_FOUND);
            return purchaseOrderModels;
    }*/

    public PurchaseOrderModel getOrderById(int purchaseOrderId) throws NoRecordFoundException {

        PurchaseOrderModel purchaseOrderModel = purchaseOrderRepo.findByPurchaseOrderId(purchaseOrderId).orElseThrow(() -> {
            return new NoRecordFoundException("NO_Id_available {}" + purchaseOrderId);
        });

        return purchaseOrderModel;
    }

    public PurchaseOrderModel insertOrder(PurchaseOrderRequest purchaseOrderRequest) {

        String projectId= ProjectDetailsUtils.generateId(StringConstants.projectId_prefix);
        PurchaseOrderModel purchaseOrderModel=new PurchaseOrderModel();
        purchaseOrderModel.setProjectId(projectId);
        purchaseOrderModel.setOrderNumber(purchaseOrderRequest.getOrderNumber());
        purchaseOrderModel.setOrderDate(purchaseOrderRequest.getOrderDate());
        purchaseOrderModel.setOrderValidTillDate(purchaseOrderRequest.getOrderValidTillDate());

        return purchaseOrderRepo.save(purchaseOrderModel);
    }

    public PurchaseOrderResponse deletePurchaseOrder(int purchaseOrderId) throws NoRecordFoundException {
        PurchaseOrderModel purchaseOrderModel=purchaseOrderRepo.findByPurchaseOrderId(purchaseOrderId).orElseThrow(()->{
            return new NoRecordFoundException("NO_Id_available :" +purchaseOrderId);
        });
        PurchaseOrderResponse purchaseOrderResponse=new PurchaseOrderResponse(purchaseOrderId,true);

            purchaseOrderRepo.delete(purchaseOrderModel);

       return purchaseOrderResponse;

    }

    public PurchaseOrderModel updateOrsave(int purchaseOrderId, PurchaseOrderRequest purchaseOrderRequest) throws NoRecordFoundException {

        PurchaseOrderModel purchaseOrderModel1=purchaseOrderRepo.findByPurchaseOrderId(purchaseOrderId).orElseThrow(()->{
            return new NoRecordFoundException("NO_Id_available {}" +purchaseOrderId);
        });

            purchaseOrderModel1.setOrderDate(purchaseOrderRequest.getOrderDate());
            purchaseOrderModel1.setOrderNumber(purchaseOrderRequest.getOrderNumber());
            purchaseOrderModel1.setOrderValidTillDate(purchaseOrderRequest.getOrderValidTillDate());
            purchaseOrderModel1.getProjectId();
            return purchaseOrderRepo.save(purchaseOrderModel1);

    }

    public PurchaseOrderModel updateOrsaveBy(String projectId, PurchaseOrderRequest purchaseOrderRequest) {


        PurchaseOrderModel purchaseOrderModel1 = purchaseOrderRepo.findByprojectId(projectId);

        purchaseOrderModel1.setOrderDate(purchaseOrderRequest.getOrderDate());
        purchaseOrderModel1.setOrderNumber(purchaseOrderRequest.getOrderNumber());
        purchaseOrderModel1.setOrderValidTillDate(purchaseOrderRequest.getOrderValidTillDate());
        purchaseOrderModel1.getProjectId();
        return purchaseOrderRepo.save(purchaseOrderModel1);
    }
}
