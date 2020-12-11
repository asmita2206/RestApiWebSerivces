package com.springboot.restapiwebservices.controller;

import com.springboot.restapiwebservices.model.AddressModel;
import com.springboot.restapiwebservices.model.PurchaseOrderModel;
import com.springboot.restapiwebservices.repository.AddressRepo;
import com.springboot.restapiwebservices.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rest/Address")
public class AddressController {

    @Autowired
    AddressRepo addressRepo;
    @Autowired
    AddressService addressService;

    @PostMapping
    public String insertAddress(  @RequestBody @Valid List<AddressModel> addressModel) {
        List<AddressModel> addressModels=addressRepo.saveAll(addressModel);
        if(addressModels!=null)
            return "your record is saved successfully !!";
        else
            return "{projectId},{addressType},{pincode} required!!";
    }


    @GetMapping("/{projectId}")
    public List<AddressModel> getAddressBy(@PathVariable("projectId")  int projectId) {

        return addressService.getAddressBy(projectId);

    }

    @DeleteMapping("/{addressId}")
    public String deleteAddressBy(@PathVariable("addressId") int addressId){
        AddressModel addressModel=addressRepo.findByAddressId(addressId);

        if(addressModel!=null) {
            addressRepo.delete(addressModel);
            return "Your {addressId} record is deleted successfully !!";
        }else
            return "Invalid {addressId}";
    }




    @PutMapping("/update/{addressId}")
    public ResponseEntity< AddressModel> updateOrsave(@PathVariable("addressId") int addressId, @Valid  @RequestBody AddressModel addressModel) {
      AddressModel addressModel1 = addressRepo.findByAddressId(addressId);
        if (addressModel1 != null) {
          addressModel1.setProjectId(addressModel.getProjectId());
          addressModel1.setPincode(addressModel.getPincode());
          addressModel1.setLine1(addressModel.getLine1());
          addressModel1.setLine2(addressModel.getLine2());
          addressModel1.setLine3(addressModel.getLine3());
          addressModel1.setAddressType(addressModel.getAddressType());
            return new ResponseEntity<>(addressRepo.save(addressModel1),HttpStatus.OK);

        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{projectId}")
    public ResponseEntity<AddressModel> update(@PathVariable("projectId") int projectId, @Valid @RequestBody AddressModel addressModel){
         AddressModel addressModel1=addressRepo.findByprojectId(projectId);
         if(addressModel1!=null) {
           //  addressModel1.setProjectId(addressModel.getProjectId());
             addressModel1.setPincode(addressModel.getPincode());
             addressModel1.setLine1(addressModel.getLine1());
             addressModel1.setLine2(addressModel.getLine2());
             addressModel1.setLine3(addressModel.getLine3());
             addressModel1.setAddressType(addressModel.getAddressType());
             return new ResponseEntity<>(addressRepo.save(addressModel1), HttpStatus.OK);
         }
         else
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
