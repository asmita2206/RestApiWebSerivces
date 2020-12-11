package com.springboot.restapiwebservices.service;

import com.springboot.restapiwebservices.constants.StringConstants;
import com.springboot.restapiwebservices.model.CompanyDetailsModel;
import com.springboot.restapiwebservices.repository.CompanyDetailsRepo;
import com.springboot.restapiwebservices.api.request.CompanyDetailsRequest;
import com.springboot.restapiwebservices.utils.ProjectDetailsUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyDetailService {

    CompanyDetailsRepo companyDetailsRepo;


    public CompanyDetailsModel insertCompanyDetails(CompanyDetailsRequest companyDetailsRequest) {
        //String companyId = className.generate(classsnaME.COMAPNY_ID_PREFIX);
         String companyId= ProjectDetailsUtils.generateId(StringConstants.companyId_prefix);

         System.out.println(companyId);
        CompanyDetailsModel companyDetailsModel =new CompanyDetailsModel();
        companyDetailsModel.setCompanyId(companyId);
        companyDetailsModel.setCompanyName(companyDetailsRequest.getCompanyName());
        companyDetailsModel.setCompanyAddress(companyDetailsRequest.getComapnyAddress());
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


}



