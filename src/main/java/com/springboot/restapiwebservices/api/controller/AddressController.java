package com.springboot.restapiwebservices.api.controller;

import com.springboot.restapiwebservices.model.AddressModel;
import com.springboot.restapiwebservices.repository.AddressRepo;
import com.springboot.restapiwebservices.api.controller.request.AddressRequest;
import com.springboot.restapiwebservices.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public AddressModel insertAddress(  @RequestBody @Valid AddressRequest addressRequest) {

            AddressModel addressModels=addressService.insertAddress(addressRequest);
            return addressModels;

    }


    @GetMapping("/{projectId}")
    public List<AddressModel> getAddressBy(@PathVariable("projectId")  String projectId) {

        return addressService.getAddressBy(projectId);

    }

    @DeleteMapping("/{addressId}")
    public String deleteAddressBy(@PathVariable("addressId") int addressId){

        addressService.deleteAddressBy(addressId);
        return "Your {addressId} record is deleted successfully !!";

    }


    @PutMapping("/update/{addressId}")
    public ResponseEntity< AddressModel> updateOrsave(@PathVariable("addressId") int addressId, @Valid  @RequestBody AddressRequest addressRequest) {

        ResponseEntity<AddressModel> addressModel1= addressService.updateOrsave(addressId,addressRequest);
       return addressModel1;


    }

    @PutMapping("/{projectId}")
    public ResponseEntity<AddressModel> update(@PathVariable("projectId") String projectId, @Valid @RequestBody AddressRequest addressRequest){

        ResponseEntity<AddressModel> addressModel1= addressService.update(projectId,addressRequest);
        return addressModel1;


    }


}
