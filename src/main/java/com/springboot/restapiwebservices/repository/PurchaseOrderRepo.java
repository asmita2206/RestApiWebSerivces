package com.springboot.restapiwebservices.repository;

import com.springboot.restapiwebservices.model.PurchaseOrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PurchaseOrderRepo extends JpaRepository<PurchaseOrderModel,Integer> {

    List<PurchaseOrderModel> findByProjectId(String projectId);
    PurchaseOrderModel findByprojectId(String projectId);
    Optional<PurchaseOrderModel> findByPurchaseOrderId(int purchaseOrderId);
}
