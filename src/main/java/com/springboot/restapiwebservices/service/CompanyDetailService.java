package com.springboot.restapiwebservices.service;

import com.springboot.restapiwebservices.constants.StringConstants;
import com.springboot.restapiwebservices.model.CompanyDetailsModel;
import com.springboot.restapiwebservices.repository.CompanyDetailsRepo;
import com.springboot.restapiwebservices.api.controller.request.CompanyDetailsRequest;
import com.springboot.restapiwebservices.utils.ProjectDetailsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyDetailService {

    @Autowired
    CompanyDetailsRepo companyDetailsRepo;
    @Autowired
    StringConstants stringConstants;

    public CompanyDetailsModel insertCompanyDetails(CompanyDetailsRequest companyDetailsRequest) {
        //String companyId = className.generate(classsnaME.COMAPNY_ID_PREFIX);
         String companyId= ProjectDetailsUtils.generateId(StringConstants.companyId_prefix);

         System.out.println(companyId);
        CompanyDetailsModel companyDetailsModel =new CompanyDetailsModel();
        companyDetailsModel.setCompanyId(companyId);
        companyDetailsModel.setCompanyName(companyDetailsRequest.getCompanyName());
        companyDetailsModel.setCompanyAddress(companyDetailsRequest.getCompanyAddress());
        return companyDetailsRepo.save(companyDetailsModel);

    }

   public List<CompanyDetailsModel> getCompanyDetails(String companyId) {
        List<CompanyDetailsModel> companyDetailsModel = companyDetailsRepo.findByCompanyId(companyId);

        if (!companyDetailsModel.isEmpty()) {
            return companyDetailsModel;

        } else
             ResponseEntity.status(HttpStatus.NOT_FOUND);
        return companyDetailsModel;

    }


    public CompanyDetailsModel deleteCompanyDetailsBy(String companyId) {
        CompanyDetailsModel companyDetailsModel = companyDetailsRepo.findBycompanyId(companyId);

           if (companyDetailsModel != null)
               companyDetailsModel.getCompanyId();
            companyDetailsRepo.delete(companyDetailsModel);

           return companyDetailsModel;

    }

    public ResponseEntity<CompanyDetailsModel> updateOrSaveBy(String companyId, CompanyDetailsRequest companyDetailsRequest) {
        CompanyDetailsModel companyDetailsModel1= companyDetailsRepo.findBycompanyId(companyId);
        if(companyDetailsModel1!=null) {
            companyDetailsModel1.setCompanyName(companyDetailsRequest.getCompanyName());
            companyDetailsModel1.setCompanyAddress(companyDetailsRequest.getCompanyAddress());
            companyDetailsModel1.getCompanyId();
            // companyDetailsModel1.setCompanyId(companyDetailsModel.getCompanyId());
            return new ResponseEntity<>(companyDetailsRepo.save(companyDetailsModel1), HttpStatus.OK);
        }else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}




