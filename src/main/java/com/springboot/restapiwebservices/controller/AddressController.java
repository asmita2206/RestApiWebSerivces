package com.springboot.restapiwebservices.controller;

import com.springboot.restapiwebservices.model.AddressModel;
import com.springboot.restapiwebservices.model.PurchaseOrderModel;
import com.springboot.restapiwebservices.repository.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {

    @Autowired
    AddressRepo addressRepo;

    @PostMapping("/saveAddress")
    public String insertOrder(@RequestBody AddressModel addressModel) {
        addressRepo.save(addressModel);
        return "your record is saved successfully !!";
    }

    @GetMapping("/getAllAddress")
    public List<AddressModel> getAllOrders() {
        return (List<AddressModel>) addressRepo.findAll();
    }

    @GetMapping("/getaddressByProjectId/{projectId}")
    public List<AddressModel> getOrderBy(@PathVariable("projectId")  int projectId) {

        return addressRepo.findByProjectId(projectId);
    }

    @DeleteMapping("deleteByAddressId/{addressId}")
    public String deleteAddressBy(@PathVariable("addressId") int addressId){
        AddressModel addressModel=addressRepo.getOne(addressId);

        addressRepo.delete(addressModel);
        return "Your {addressId} record is deleted successfully !!";
    }


    @PutMapping("/updateAddress")
    public List<AddressModel> saveOrupdateAddress(@RequestBody List<AddressModel> addressModel) {
        addressRepo.saveAll(addressModel);
        return addressModel;
    }

    @PutMapping("/updateByAddressId/{addressId}")
    public AddressModel updateOrsave(@PathVariable("addressId") int addressId,@RequestBody AddressModel addressModel){

        return addressRepo.save(addressModel);
    }

    @PutMapping("/updateAddressByProjectId/{projectId}")
    public AddressModel updateOrsaveBy(@PathVariable("projectId") int projectId,@RequestBody AddressModel addressModel){

        return addressRepo.save(addressModel);
    }


}
