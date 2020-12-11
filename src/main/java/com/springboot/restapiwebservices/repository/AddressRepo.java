package com.springboot.restapiwebservices.repository;

import com.springboot.restapiwebservices.model.AddressModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepo extends JpaRepository<AddressModel,Integer> {

    List<AddressModel> findByProjectId(String projectId);
    AddressModel findByprojectId(String projectId);
    AddressModel findByAddressId(int addressId);
}
