package com.springboot.restapiwebservices.api.controller;

import com.springboot.restapiwebservices.model.PurchaseOrderModel;
import com.springboot.restapiwebservices.repository.PurchaseOrderRepo;
import com.springboot.restapiwebservices.service.PurchaseOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rest/PurchaseOrder")
public class PurchaseOrderController {

    PurchaseOrderRepo purchaseOrderRepo;
    PurchaseOrderService purchaseOrderService;

    @PostMapping
    public String insertOrder(@RequestBody @Valid List<PurchaseOrderModel> purchaseOrderModel) {

        List<PurchaseOrderModel> purchaseOrderModels= purchaseOrderRepo.saveAll(purchaseOrderModel);
           if(purchaseOrderModels!=null)
            return "your record is saved successfully !!";
           else
            return "{projectId},{orderNumber},{orderValidTillDate} required!!";

    }

    @GetMapping("/{projectId}")
    public List<PurchaseOrderModel> getOrder(@PathVariable("projectId") int projectId){
        return purchaseOrderService.getOrderBy(projectId);
    }

    @GetMapping("/{purchaseOrderId}")
    public ResponseEntity<PurchaseOrderModel> getOrderById(@PathVariable("purchaseOrderId") int purchaseOrderId){
        return purchaseOrderService.getOrderById(purchaseOrderId);
    }


    @DeleteMapping("/{purchaseOrderId}")
    public String deletePurchaseOrder(@PathVariable("purchaseOrderId") int purchaseOrderId){
       PurchaseOrderModel purchaseOrderModel=purchaseOrderRepo.findByPurchaseOrderId(purchaseOrderId);

        if(purchaseOrderModel!=null) {
            purchaseOrderRepo.delete(purchaseOrderModel);
            return "Your {purchaseOrderId} record is deleted successfully !!";
        }else
            return "Invalid {purchaseOrderId}";
    }


    @PutMapping("/{purchaseOrderId}")
    public ResponseEntity<PurchaseOrderModel> updateOrsave(@PathVariable("purchaseOrderId") int purchaseOrderId, @Valid @RequestBody PurchaseOrderModel purchaseOrderModel){
        PurchaseOrderModel purchaseOrderModel1=purchaseOrderRepo.findByPurchaseOrderId(purchaseOrderId);
        if(purchaseOrderModel1!=null) {
            purchaseOrderModel1.setOrderDate(purchaseOrderModel.getOrderDate());
            purchaseOrderModel1.setOrderNumber(purchaseOrderModel.getOrderNumber());
            purchaseOrderModel1.setOrderValidTillDate(purchaseOrderModel.getOrderValidTillDate());
            purchaseOrderModel1.setProjectId(purchaseOrderModel.getProjectId());
            return new ResponseEntity<>(purchaseOrderRepo.save(purchaseOrderModel1), HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{projectId}")
    public ResponseEntity<PurchaseOrderModel> updateOrsaveBy(@PathVariable("projectId") int projectId, @Valid @RequestBody PurchaseOrderModel purchaseOrderModel){
       PurchaseOrderModel purchaseOrderModel1=purchaseOrderRepo.findByprojectId(projectId);

       if(purchaseOrderModel1!=null) {
           purchaseOrderModel1.setOrderDate(purchaseOrderModel.getOrderDate());
           purchaseOrderModel1.setOrderNumber(purchaseOrderModel.getOrderNumber());
           purchaseOrderModel1.setOrderValidTillDate(purchaseOrderModel.getOrderValidTillDate());
          // purchaseOrderModel1.setProjectId(purchaseOrderModel.getProjectId());
           return new ResponseEntity<>(purchaseOrderRepo.save(purchaseOrderModel1), HttpStatus.OK);
       }else
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
