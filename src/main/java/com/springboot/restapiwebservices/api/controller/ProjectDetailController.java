package com.springboot.restapiwebservices.api.controller;

import com.springboot.restapiwebservices.model.ProjectDetailsModel;
import com.springboot.restapiwebservices.repository.ProjectDetailRepo;
import com.springboot.restapiwebservices.api.controller.request.ProjectDetailRequest;
import com.springboot.restapiwebservices.service.ProjectDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rest/ProjectDetails")
public class ProjectDetailController {

    @Autowired
    ProjectDetailRepo projectDetailRepo;
    @Autowired
    ProjectDetailService projectDetailService;

    @PostMapping
    public ProjectDetailsModel insertProjectDetails(@RequestBody @Valid ProjectDetailRequest projectDetailRequest) {

       ProjectDetailsModel projectDetailsModels=projectDetailService.insertProjectDetails(projectDetailRequest);
      //  return "your record is saved successfully !!";

        return projectDetailsModels;


  }

    @GetMapping("/get/{projectId}")
    public ProjectDetailsModel getDetails(@PathVariable("projectId") String projectId)  {

        return projectDetailService.getDetails(projectId);
    }

        @GetMapping("/{companyId}")
        public List<ProjectDetailsModel> getDetailsby(@PathVariable("companyId")  String companyId) {

            return projectDetailService.getDetailsby(companyId);

        }


    @DeleteMapping("/{projectId}")
    public String deleteProjectDetails(@PathVariable("projectId") String projectId) {

        projectDetailService.deleteProjectDetails(projectId);
        return "Your {projectId} record is deleted successfully !!";

    }


    @PutMapping("/{companyId}")
    public ResponseEntity<ProjectDetailsModel> updateOrsave(@PathVariable("companyId") String companyId, @Valid @RequestBody ProjectDetailRequest projectDetailRequest){

       ResponseEntity< ProjectDetailsModel> projectDetailsModel1=projectDetailService.updateOrsave(companyId,projectDetailRequest);
        return projectDetailsModel1;
    }

    @PutMapping("/update/{projectId}")
    public ResponseEntity<ProjectDetailsModel> updateOrsaveBy(@PathVariable("projectId") String projectId,@Valid @RequestBody ProjectDetailRequest projectDetailRequest) {

        ResponseEntity< ProjectDetailsModel> projectDetailsModel1=projectDetailService.updateOrsaveBy(projectId,projectDetailRequest);
        return projectDetailsModel1;

    }
}
