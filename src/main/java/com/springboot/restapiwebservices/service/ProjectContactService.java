package com.springboot.restapiwebservices.service;

import com.springboot.restapiwebservices.constants.StringConstants;
import com.springboot.restapiwebservices.model.ProjectContactModel;
import com.springboot.restapiwebservices.repository.ProjectContactRepo;
import com.springboot.restapiwebservices.api.controller.request.ProjectContactRequest;
import com.springboot.restapiwebservices.utils.ProjectDetailsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectContactService {

    @Autowired
    ProjectContactRepo projectContactRepo;

    public ProjectContactModel insertProjectContact(ProjectContactRequest projectContactRequest) {

        String projectId= ProjectDetailsUtils.generateId(StringConstants.projectId_prefix);
        ProjectContactModel projectContactModel=new ProjectContactModel();
        projectContactModel.setProjectId(projectId);
        projectContactModel.setContactType(projectContactRequest.getContactType());
        projectContactModel.setContactNumber(projectContactRequest.getContactNumber());
        projectContactModel.setContactName(projectContactRequest.getContactName());
        projectContactModel.setContactEmail(projectContactRequest.getContactEmail());

        return projectContactRepo.save(projectContactModel);
    }

    public List<ProjectContactModel> getContactDetails(String projectId) {
        List<ProjectContactModel> projectContactModels=projectContactRepo.findByProjectId(projectId);

        if(!projectContactModels.isEmpty())
            return projectContactModels;
        else
            //return new  ResponseEntity<>"not found {}" +projectId,HttpStatus.NOT_FOUND);
            ResponseEntity.status(HttpStatus.NOT_FOUND);
         return projectContactModels;
    }

    public ProjectContactModel getContactDetailsById(int projectContactId ) {
        ProjectContactModel projectContactModel= projectContactRepo.findByProjectContactId(projectContactId);

        if(projectContactModel!=null)
           return projectContactModel;
        else
             ResponseEntity.status(HttpStatus.NOT_FOUND);
        return projectContactModel;
    }

    public ProjectContactModel deleteProjectContact(int projectContactId) {

        ProjectContactModel projectContactModel=projectContactRepo.findByProjectContactId(projectContactId);
        if(projectContactModel!=null)
            projectContactRepo.delete(projectContactModel);
        return projectContactModel;
    }

    public ResponseEntity<ProjectContactModel> updateOrsave(int projectContactId, ProjectContactRequest projectContactRequest) {

        ProjectContactModel projectContactModel1=projectContactRepo.findByProjectContactId(projectContactId);

        if(projectContactModel1!=null) {
            projectContactModel1.setContactEmail(projectContactRequest.getContactEmail());
            projectContactModel1.setContactName(projectContactRequest.getContactName());
            projectContactModel1.setContactNumber(projectContactRequest.getContactNumber());
            projectContactModel1.setContactType(projectContactRequest.getContactType());
            projectContactModel1.getProjectId();
            return new ResponseEntity<>(projectContactRepo.save(projectContactModel1), HttpStatus.OK);
        }else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<ProjectContactModel> updateOrsaveBy(String projectId, ProjectContactRequest projectContactRequest) {

        ProjectContactModel projectContactModel1=projectContactRepo.findByprojectId(projectId);
        if(projectContactModel1!=null) {
            projectContactModel1.setContactEmail(projectContactRequest.getContactEmail());
            projectContactModel1.setContactName(projectContactRequest.getContactName());
            projectContactModel1.setContactNumber(projectContactRequest.getContactNumber());
            projectContactModel1.setContactType(projectContactRequest.getContactType());
             projectContactModel1.getProjectId();
            return new ResponseEntity<>(projectContactRepo.save(projectContactModel1), HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
