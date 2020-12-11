package com.springboot.restapiwebservices.api.controller;

import com.springboot.restapiwebservices.model.CompanyDetailsModel;
import com.springboot.restapiwebservices.repository.CompanyDetailsRepo;
import com.springboot.restapiwebservices.api.controller.request.CompanyDetailsRequest;
import com.springboot.restapiwebservices.service.CompanyDetailService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rest/CompanyDetails")
public class CompanyDetailsController {

    @Autowired
    CompanyDetailsRepo companyDetailsRepo;
    @Autowired
    CompanyDetailService companyDetailService;

    @PostMapping
    public CompanyDetailsModel insertCompanyDetails(@RequestBody @Valid CompanyDetailsRequest companyDetailsRequest) {

        CompanyDetailsModel companyDetailsModels = companyDetailService.insertCompanyDetails(companyDetailsRequest);


        return companyDetailsModels;


    }


    @GetMapping("/{companyId}")
    @ApiResponses(value = {@ApiResponse(code = 404, message = "Data not Found")})

    public List<CompanyDetailsModel> getCompanyDetailsBy(@PathVariable("companyId") String companyId) {


        return companyDetailService.getCompanyDetails(companyId);

    }

    @DeleteMapping("/{companyId}")
    public String deleteCompanyDetailsBy(@PathVariable("companyId") String companyId) {

        companyDetailService.deleteCompanyDetailsBy(companyId);
        return "Your {companyId} record is deleted successfully !!";

    }


    @PutMapping("/{companyId}")
    public ResponseEntity<CompanyDetailsModel> updateOrSaveBy(@PathVariable("companyId") String companyId, @RequestBody @Valid CompanyDetailsRequest companyDetailsRequest) {

        ResponseEntity<CompanyDetailsModel> companyDetailsModel = companyDetailService.updateOrSaveBy(companyId, companyDetailsRequest);
        return companyDetailsModel;

    }
}

