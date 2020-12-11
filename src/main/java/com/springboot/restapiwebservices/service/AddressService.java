package com.springboot.restapiwebservices.service;

import com.springboot.restapiwebservices.model.AddressModel;
import com.springboot.restapiwebservices.repository.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    AddressRepo addressRepo;

    public List<AddressModel> getAddressBy(int projectId) {
       List<AddressModel>addressModels= addressRepo.findByProjectId(projectId);

       if(!addressModels.isEmpty())
           return addressModels;
       else
           ResponseEntity.status(HttpStatus.NOT_FOUND);
           return addressModels;
    }
}
