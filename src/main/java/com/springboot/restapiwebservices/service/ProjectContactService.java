package com.springboot.restapiwebservices.service;

import com.springboot.restapiwebservices.model.CompanyDetailsModel;
import com.springboot.restapiwebservices.model.ProjectContactModel;
import com.springboot.restapiwebservices.repository.ProjectContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectContactService {

    ProjectContactRepo projectContactRepo;

    public List<ProjectContactModel> insertProjectContact(List<ProjectContactModel> projectContactModel) {
        return projectContactRepo.saveAll(projectContactModel);
    }

    public List<ProjectContactModel> getContactDetails(int projectId) {
        List<ProjectContactModel> projectContactModels=projectContactRepo.findByProjectId(projectId);

        if(!projectContactModels.isEmpty())
            return projectContactModels;
        else
            //return new  ResponseEntity<>"not found {}" +projectId,HttpStatus.NOT_FOUND);
            ResponseEntity.status(HttpStatus.NOT_FOUND);
         return projectContactModels;
    }

   /* public ProjectContactModel getContactDetailsById(int projectContactId ) {
        ProjectContactModel projectContactModel= projectContactRepo.findByProjectContactId(projectContactId);
        int projectcontactId=0;


        for (ProjectContactModel projectcontact : projectContactModel){
          projectcontactId=  projectcontact.getProjectContactId();
        }

      // if(projectContactModel!=null)
        if(projectcontactId==projectContactId)
            return projectContactModel;
        else
             ResponseEntity.status(HttpStatus.NOT_FOUND);
        return projectContactModel;
    }*/
}
