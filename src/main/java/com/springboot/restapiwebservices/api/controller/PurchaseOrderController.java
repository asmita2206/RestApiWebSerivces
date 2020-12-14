package com.springboot.restapiwebservices.api.controller;

import com.springboot.restapiwebservices.exception.NoRecordFoundException;
import com.springboot.restapiwebservices.model.PurchaseOrderModel;
import com.springboot.restapiwebservices.repository.PurchaseOrderRepo;
import com.springboot.restapiwebservices.api.controller.request.PurchaseOrderRequest;
import com.springboot.restapiwebservices.response.PurchaseOrderResponse;
import com.springboot.restapiwebservices.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rest/PurchaseOrder")
public class PurchaseOrderController {

    @Autowired
    PurchaseOrderRepo purchaseOrderRepo;
    @Autowired
    PurchaseOrderService purchaseOrderService;

    @PostMapping
    public PurchaseOrderModel insertOrder(@RequestBody @Valid PurchaseOrderRequest purchaseOrderRequest) {

      PurchaseOrderModel purchaseOrderModels=purchaseOrderService.insertOrder(purchaseOrderRequest);
            return purchaseOrderModels;
    }

   /* @GetMapping("/get/{projectId}")
    public List<PurchaseOrderModel> getOrder(@PathVariable("projectId") String projectId){
        return purchaseOrderService.getOrderBy(projectId);
    }
*/
    @GetMapping("/{purchaseOrderId}")
    public PurchaseOrderModel getOrderById(@PathVariable("purchaseOrderId") int purchaseOrderId) throws NoRecordFoundException {
        return purchaseOrderService.getOrderById(purchaseOrderId);
    }


    @DeleteMapping("/{purchaseOrderId}")
    public PurchaseOrderResponse deletePurchaseOrder(@PathVariable("purchaseOrderId") int purchaseOrderId) throws NoRecordFoundException {

       PurchaseOrderResponse purchaseOrderResponse= purchaseOrderService.deletePurchaseOrder(purchaseOrderId);

       return purchaseOrderResponse;
      /* if(purchaseOrderResponse!=null)
       purchaseOrderResponse.getPurchaseOrderIdDeleted();
       return purchaseOrderResponse;*/
      // "Your {purchaseOrderId} record is deleted successfully !!";
       /* PurchaseOrderResponse purchaseOrderResponse=new PurchaseOrderResponse();
        purchaseOrderResponse.getPurchaseOrderId();*/
//        return purchaseOrderResponse;

    }


    @PutMapping("/update/{purchaseOrderId}")
    public PurchaseOrderModel updateOrsave(@PathVariable("purchaseOrderId") int purchaseOrderId, @Valid @RequestBody PurchaseOrderRequest purchaseOrderRequest) throws NoRecordFoundException {

    PurchaseOrderModel purchaseOrderModel1=purchaseOrderService.updateOrsave(purchaseOrderId,purchaseOrderRequest);
      return purchaseOrderModel1;

    }

    @PutMapping("/{projectId}")
    public PurchaseOrderModel updateOrsaveBy(@PathVariable("projectId") String projectId, @Valid @RequestBody PurchaseOrderRequest purchaseOrderRequest){

        PurchaseOrderModel purchaseOrderModel1=purchaseOrderService.updateOrsaveBy(projectId,purchaseOrderRequest);
        return purchaseOrderModel1;

    }


}
