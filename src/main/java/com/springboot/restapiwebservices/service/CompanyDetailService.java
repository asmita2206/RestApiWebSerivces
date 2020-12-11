package com.springboot.restapiwebservices.service;

import com.springboot.restapiwebservices.constants.StringConstants;
import com.springboot.restapiwebservices.constants.StringVariables;
import com.springboot.restapiwebservices.model.CompanyDetailsModel;
import com.springboot.restapiwebservices.repository.CompanyDetailsRepo;
import com.springboot.restapiwebservices.request.CompanyDetailsRequest;
import com.springboot.restapiwebservices.response.CompanyDetailsResponse;
import com.springboot.restapiwebservices.utils.ProjectDetailsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyDetailService {

    @Autowired
    CompanyDetailsRepo companyDetailsRepo;

    @Autowired
    StringConstants stringConstants;
    @Autowired
    StringVariables stringVariables;

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



