package com.springboot.restapiwebservices.service;

import com.springboot.restapiwebservices.constants.StringConstants;
import com.springboot.restapiwebservices.model.AddressModel;
import com.springboot.restapiwebservices.repository.AddressRepo;
import com.springboot.restapiwebservices.api.controller.request.AddressRequest;
import com.springboot.restapiwebservices.utils.ProjectDetailsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    AddressRepo addressRepo;

    public List<AddressModel> getAddressBy(String projectId) {
       List<AddressModel>addressModels= addressRepo.findByProjectId(projectId);

       if(!addressModels.isEmpty())
           return addressModels;
       else
           ResponseEntity.status(HttpStatus.NOT_FOUND);
           return addressModels;
    }

    public AddressModel insertAddress(AddressRequest addressRequest) {

        String projectId= ProjectDetailsUtils.generateId(StringConstants.projectId_prefix);
        AddressModel addressModel=new AddressModel();
        addressModel.setProjectId(projectId);
        addressModel.setAddressType(addressRequest.getAddressType());
        addressModel.setLine1(addressRequest.getLine1());
        addressModel.setLine2(addressRequest.getLine2());
        addressModel.setLine3(addressRequest.getLine3());
        addressModel.setPincode(addressRequest.getPincode());

        return addressRepo.save(addressModel);


    }

    public void deleteAddressBy(int addressId) {
        AddressModel addressModel=addressRepo.findByAddressId(addressId);
        if(addressModel!=null) {
            addressRepo.delete(addressModel);}
    }

    public ResponseEntity<AddressModel> updateOrsave(int addressId,AddressRequest addressRequest) {


        AddressModel addressModel1 = addressRepo.findByAddressId(addressId);
        if (addressModel1 != null) {
            addressModel1.setPincode(addressRequest.getPincode());
            addressModel1.setLine1(addressRequest.getLine1());
            addressModel1.setLine2(addressRequest.getLine2());
            addressModel1.setLine3(addressRequest.getLine3());
            addressModel1.setAddressType(addressRequest.getAddressType());
            addressModel1.getAddressId();
            addressModel1.getProjectId();
            return new ResponseEntity<>(addressRepo.save(addressModel1),HttpStatus.OK);

        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<AddressModel> update(String projectId, AddressRequest addressRequest) {

        AddressModel addressModel1 = addressRepo.findByprojectId(projectId);
        if (addressModel1 != null) {
            addressModel1.setPincode(addressRequest.getPincode());
            addressModel1.setLine1(addressRequest.getLine1());
            addressModel1.setLine2(addressRequest.getLine2());
            addressModel1.setLine3(addressRequest.getLine3());
            addressModel1.setAddressType(addressRequest.getAddressType());
            addressModel1.getAddressId();
            addressModel1.getProjectId();
            return new ResponseEntity<>(addressRepo.save(addressModel1),HttpStatus.OK);

        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
