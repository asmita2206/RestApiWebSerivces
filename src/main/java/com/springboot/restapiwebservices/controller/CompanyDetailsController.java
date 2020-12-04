package com.springboot.restapiwebservices.controller;

import com.springboot.restapiwebservices.model.CompanyDetailsModel;
import com.springboot.restapiwebservices.model.ProjectDetailsModel;
import com.springboot.restapiwebservices.repository.CompanyDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyDetailsController {

    @Autowired
    CompanyDetailsRepo companyDetailsRepo;

    @PostMapping("/saveCompanyDetails")
    public String insertCompanyDetails(@RequestBody List<CompanyDetailsModel> companyDetailsModel) {
     companyDetailsRepo.saveAll(companyDetailsModel);
        return "your company record is saved successfully !!";
    }

    @GetMapping("/getAllCompanyDetails")
    public List<CompanyDetailsModel> getCompanyDetails() {
        return (List<CompanyDetailsModel>) companyDetailsRepo.findAll();
    }

    @GetMapping("/getByCompanyId/{companyId}")
    public List<CompanyDetailsModel> getCompanyDetails(@PathVariable("companyId")  int companyId) {

        return companyDetailsRepo.findByCompanyId(companyId);

    }

    @DeleteMapping("deleteByCompanyId/{companyId}")
    public String  deleteCompanyDetails(@PathVariable("companyId") int companyId){
        CompanyDetailsModel companyDetailsModel=companyDetailsRepo.getOne(companyId);

        companyDetailsRepo.delete(companyDetailsModel);
        //return (List<CompanyDetailsModel>) companyDetailsRepo.findAll();
        return "Your {companyId} record is deleted successfully !!";
    }


    @PutMapping("/updateCompanyDetails")
    public List<CompanyDetailsModel> saveOrupdateCompanyDetails(@RequestBody List<CompanyDetailsModel> companyDetailsModel) {
        companyDetailsRepo.saveAll(companyDetailsModel);
        return companyDetailsModel;
    }

    @PutMapping("/updateByCompanyId/{companyId}")
    public CompanyDetailsModel updateOrSaveBy(@PathVariable("companyId") int companyId,@RequestBody CompanyDetailsModel companyDetailsModel){

         // companyDetailsRepo.findByCompanyId(companyId);

          return companyDetailsRepo.save(companyDetailsModel);
          //  return companyDetailsModel;
        }

}


