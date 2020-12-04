package com.springboot.restapiwebservices.controller;

import com.springboot.restapiwebservices.model.ProjectContactModel;
import com.springboot.restapiwebservices.model.PurchaseOrderModel;
import com.springboot.restapiwebservices.repository.PurchaseOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PurchaseOrderController {

    @Autowired
    PurchaseOrderRepo purchaseOrderRepo;

    @PostMapping("/saveOrder")
    public String insertOrder(@RequestBody PurchaseOrderModel purchaseOrderModel) {
        purchaseOrderRepo.save(purchaseOrderModel);
        return "your record is saved successfully !!";
    }

    @GetMapping("/getAllOrders")
    public List<PurchaseOrderModel> getAllOrders() {
        return (List<PurchaseOrderModel>) purchaseOrderRepo.findAll();
    }

    @GetMapping("/getOrderByProjectId/{projectId}")
    public List<PurchaseOrderModel> getOrderBy(@PathVariable("projectId")  int projectId) {

        return purchaseOrderRepo.findByProjectId(projectId);
    }

    @DeleteMapping("deleteByPurchaseOrderId/{purchaseOrderId}")
    public String deletePurchaseOrder(@PathVariable("purchaseOrderId") int purchaseOrderId){
        PurchaseOrderModel purchaseOrderModel=purchaseOrderRepo.getOne(purchaseOrderId);

        purchaseOrderRepo.delete(purchaseOrderModel);
        return "Your {purchaseOrderId} record is deleted successfully !!";
    }


    @PutMapping("/updatePurchaseOrder")
    public List<PurchaseOrderModel> saveOrupdatePurchaseOrder(@RequestBody List<PurchaseOrderModel> purchaseOrderModel) {
        purchaseOrderRepo.saveAll(purchaseOrderModel);
        return purchaseOrderModel;
    }

    @PutMapping("/updateByPurchaseOrderId/{purchaseOrderId}")
    public PurchaseOrderModel updateOrsave(@PathVariable("purchaseOrderId") int purchaseOrderId,@RequestBody PurchaseOrderModel purchaseOrderModel){

        return purchaseOrderRepo.save(purchaseOrderModel);
    }

    @PutMapping("/updateOrderByProjectId/{projectId}")
    public PurchaseOrderModel updateOrsaveBy(@PathVariable("projectId") int projectId,@RequestBody PurchaseOrderModel purchaseOrderModel){

        return purchaseOrderRepo.save(purchaseOrderModel);
    }


}
