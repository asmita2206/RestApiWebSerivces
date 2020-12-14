package com.springboot.restapiwebservices.service;

import com.springboot.restapiwebservices.constants.StringConstants;
import com.springboot.restapiwebservices.exception.NoRecordFoundException;
import com.springboot.restapiwebservices.model.ProjectDetailsModel;
import com.springboot.restapiwebservices.repository.ProjectDetailRepo;
import com.springboot.restapiwebservices.api.controller.request.ProjectDetailRequest;
import com.springboot.restapiwebservices.response.ProjectDetailResponse;
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


   /* public List<ProjectDetailsModel> getDetailsby(String companyId) {
        List<ProjectDetailsModel> projectDetailsModels=projectDetailRepo.findByCompanyId(companyId);

        if(!projectDetailsModels.isEmpty())
            return projectDetailsModels;
        else
            ResponseEntity.status(HttpStatus.NOT_FOUND);
        return projectDetailsModels;
    }
*/
    public ProjectDetailsModel getDetails(String projectId) throws NoRecordFoundException {
       ProjectDetailsModel projectDetailsModels = projectDetailRepo.findByProjectId(projectId).orElseThrow(()->{
           return new NoRecordFoundException("no_Id_forund :" +projectId);
       });

        return projectDetailsModels;
    }


    public ProjectDetailResponse deleteProjectDetails(String projectId) throws NoRecordFoundException {

        ProjectDetailsModel projectDetailsModels = projectDetailRepo.findByProjectId(projectId).orElseThrow(()->{
            return new NoRecordFoundException("no_Id_forund :" +projectId);
        });
        ProjectDetailResponse projectDetailResponse=new ProjectDetailResponse(projectId,true);

            projectDetailsModels.getProjectId();
            projectDetailRepo.delete(projectDetailsModels);
            return projectDetailResponse;

    }

    public ProjectDetailsModel updateOrsave(String companyId, ProjectDetailRequest projectDetailRequest) throws NoRecordFoundException {

        ProjectDetailsModel projectDetailsModel1=projectDetailRepo.findBycompanyId(companyId).orElseThrow(()->{
            return new NoRecordFoundException("NO_Id_found" +companyId);
        });

            projectDetailsModel1.setProjectName(projectDetailRequest.getProjectName());
            projectDetailsModel1.setClientName(projectDetailRequest.getClientName());
            projectDetailsModel1.getProjectId();
            return projectDetailRepo.save(projectDetailsModel1);
    }

    public ProjectDetailsModel updateOrsaveBy(String projectId, ProjectDetailRequest projectDetailRequest) throws NoRecordFoundException {

        ProjectDetailsModel projectDetailsModel1 = projectDetailRepo.findByProjectId(projectId).orElseThrow(()->{
            return new NoRecordFoundException("no_Id_forund :" +projectId);
        });

            projectDetailsModel1.setProjectName(projectDetailRequest.getProjectName());
            projectDetailsModel1.setClientName(projectDetailRequest.getClientName());
            projectDetailsModel1.getCompanyId();
            return projectDetailRepo.save(projectDetailsModel1);

    }
}
