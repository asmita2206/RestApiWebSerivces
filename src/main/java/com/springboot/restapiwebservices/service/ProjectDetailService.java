package com.springboot.restapiwebservices.service;

import com.springboot.restapiwebservices.model.CompanyDetailsModel;
import com.springboot.restapiwebservices.model.ProjectContactModel;
import com.springboot.restapiwebservices.model.ProjectDetailsModel;
import com.springboot.restapiwebservices.repository.ProjectDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.restapiwebservices.service.NoRecordFoundException;

import java.util.List;
import java.util.UUID;

@Service
public class ProjectDetailService {

  @Autowired
    ProjectDetailRepo projectDetailRepo;

    public List<ProjectDetailsModel> insertProjectDetails(List<ProjectDetailsModel> projectDetailsModels) {

        
        return projectDetailRepo.saveAll(projectDetailsModels);
    }


    public List<ProjectDetailsModel> getDetailsby(int companyId) {
        List<ProjectDetailsModel> projectDetailsModels=projectDetailRepo.findByCompanyId(companyId);

        if(!projectDetailsModels.isEmpty())
            return projectDetailsModels;
        else
            ResponseEntity.status(HttpStatus.NOT_FOUND);
        return projectDetailsModels;
    }

   /* public ProjectDetailsModel getDetails(UUID projectId)throws NoRecordFoundException {
       ProjectDetailsModel projectDetailsModels;
        projectDetailsModels = projectDetailRepo.findByProjectId(projectId).orElseThrow(()->{
            return new NoRecordFoundException("no record found{} " + projectId);
        });


        return projectDetailsModels;
    }
*/


}
