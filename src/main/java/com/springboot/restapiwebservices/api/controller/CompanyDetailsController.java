package com.springboot.restapiwebservices.api.controller;

import com.springboot.restapiwebservices.model.CompanyDetailsModel;
import com.springboot.restapiwebservices.repository.CompanyDetailsRepo;
import com.springboot.restapiwebservices.api.request.CompanyDetailsRequest;
import com.springboot.restapiwebservices.service.CompanyDetailService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rest/CompanyDetails")
public class CompanyDetailsController {

    CompanyDetailsRepo companyDetailsRepo;
    CompanyDetailService companyDetailService;

    @PostMapping
    public CompanyDetailsModel insertCompanyDetails(@RequestBody @Valid CompanyDetailsRequest companyDetailsRequest) {

        CompanyDetailsModel companyDetailsModels = companyDetailService.insertCompanyDetails(companyDetailsRequest);


         return companyDetailsModels ;


    }


    @GetMapping("/{companyId}")
     @ApiResponses(value = {  @ApiResponse(code = 404,message = "Data not Found")})

    public List<CompanyDetailsModel> getCompanyDetailsBy(@PathVariable("companyId") String companyId) {


        return companyDetailService.getCompanyDetails(companyId);

    }

    @DeleteMapping("/{companyId}")
    public String deleteCompanyDetailsBy(@PathVariable("companyId") String companyId) {
        CompanyDetailsModel companyDetailsModel = companyDetailsRepo.findBycompanyId(companyId);

        if (companyDetailsModel != null) {
            companyDetailsRepo.delete(companyDetailsModel);
            return "Your {companyId} record is deleted successfully !!";
        } else
             new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
            return "Invalid {companyId}";

    }


    @PutMapping("/{companyId}")
    public ResponseEntity<CompanyDetailsModel> updateOrSaveBy(@PathVariable("companyId") String companyId, @RequestBody @Valid CompanyDetailsModel companyDetailsModel){

       CompanyDetailsModel companyDetailsModel1= companyDetailsRepo.findBycompanyId(companyId);
           if(companyDetailsModel1!=null) {
               companyDetailsModel1.setCompanyName(companyDetailsModel.getCompanyName());
               companyDetailsModel1.setCompanyAddress(companyDetailsModel.getCompanyAddress());
              // companyDetailsModel1.setCompanyId(companyDetailsModel.getCompanyId());
               return new ResponseEntity<>(companyDetailsRepo.save(companyDetailsModel1), HttpStatus.OK);
           }else
               return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

}


