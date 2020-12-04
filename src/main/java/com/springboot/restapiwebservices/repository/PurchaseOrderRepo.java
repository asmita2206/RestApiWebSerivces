package com.springboot.restapiwebservices.repository;

import com.springboot.restapiwebservices.model.PurchaseOrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseOrderRepo extends JpaRepository<PurchaseOrderModel,Integer> {

    List<PurchaseOrderModel> findByProjectId(int projectId);
}
