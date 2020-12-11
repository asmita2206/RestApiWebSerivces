package com.springboot.restapiwebservices.service;

import com.springboot.restapiwebservices.constants.StringConstants;
import com.springboot.restapiwebservices.model.ProjectDetailsModel;
import com.springboot.restapiwebservices.repository.ProjectDetailRepo;
import com.springboot.restapiwebservices.api.controller.request.ProjectDetailRequest;
import com.springboot.restapiwebservices.utils.ProjectDetailsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectDetailService {

    @Autowired
    ProjectDetailRepo projectDetailRepo;

    public ProjectDetailsModel insertProjectDetails(ProjectDetailRequest projectDetailRequest) {

        String projectId= ProjectDetailsUtils.generateId(StringConstants.projectId_prefix);
        String clientId=ProjectDetailsUtils.generateId(StringConstants.clientId_prefix);
        String companyId=ProjectDetailsUtils.generateId(StringConstants.companyId_prefix);
        ProjectDetailsModel projectDetailsModel=new ProjectDetailsModel();
        projectDetailsModel.setProjectName(projectDetailRequest.getProjectName());
        projectDetailsModel.setClientName(projectDetailRequest.getClientName());
        projectDetailsModel.setClientId(clientId);
        projectDetailsModel.setCompanyId(companyId);
        projectDetailsModel.setProjectId(projectId);

        return projectDetailRepo.save(projectDetailsModel);
    }


    public List<ProjectDetailsModel> getDetailsby(String companyId) {
        List<ProjectDetailsModel> projectDetailsModels=projectDetailRepo.findByCompanyId(companyId);

        if(!projectDetailsModels.isEmpty())
            return projectDetailsModels;
        else
            ResponseEntity.status(HttpStatus.NOT_FOUND);
        return projectDetailsModels;
    }

    public ProjectDetailsModel getDetails(String projectId) {
       ProjectDetailsModel projectDetailsModels = projectDetailRepo.findByProjectId(projectId);

      if(projectDetailsModels!=null)
        return projectDetailsModels;

        else
        ResponseEntity.status(HttpStatus.NOT_FOUND);
        return projectDetailsModels;
    }


    public void deleteProjectDetails(String projectId) {

        ProjectDetailsModel projectDetailsModels = projectDetailRepo.findByProjectId(projectId);

        if (projectDetailsModels != null) {
            projectDetailsModels.getProjectId();
            projectDetailRepo.delete(projectDetailsModels);
        }
    }

    public ResponseEntity<ProjectDetailsModel> updateOrsave(String companyId, ProjectDetailRequest projectDetailRequest) {

        ProjectDetailsModel projectDetailsModel1=projectDetailRepo.findBycompanyId(companyId);
        if(projectDetailsModel1!=null) {
            projectDetailsModel1.setProjectName(projectDetailRequest.getProjectName());
            projectDetailsModel1.setClientName(projectDetailRequest.getClientName());
            projectDetailsModel1.getProjectId();
            return new ResponseEntity<>(projectDetailRepo.save(projectDetailsModel1), HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<ProjectDetailsModel> updateOrsaveBy(String projectId, ProjectDetailRequest projectDetailRequest) {

        ProjectDetailsModel projectDetailsModel1 = projectDetailRepo.findByProjectId(projectId);

        if (projectDetailsModel1 != null) {
            projectDetailsModel1.setProjectName(projectDetailRequest.getProjectName());
            projectDetailsModel1.setClientName(projectDetailRequest.getClientName());
            projectDetailsModel1.getCompanyId();
            return new ResponseEntity<>(projectDetailRepo.save(projectDetailsModel1), HttpStatus.OK);

        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}
