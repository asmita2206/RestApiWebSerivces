package com.springboot.restapiwebservices.api.controller;

import com.springboot.restapiwebservices.model.ProjectDetailsModel;
import com.springboot.restapiwebservices.repository.ProjectDetailRepo;
import com.springboot.restapiwebservices.service.ProjectDetailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/rest/ProjectDetails")
public class ProjectDetailController {

    ProjectDetailRepo projectDetailRepo;
    ProjectDetailService projectDetailService;

    @PostMapping
    public String insertProjectDetails(@RequestBody @Valid List<ProjectDetailsModel> projectDetailsModel) {
      try {
        List<ProjectDetailsModel> projectDetailsModels=projectDetailService.insertProjectDetails(projectDetailsModel);
        return "your record is saved successfully !!";
    }catch (Exception e){
        new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return "{ProjectName} required !!";
    }

  }

   /* @GetMapping("/{projectId}")
    public ProjectDetailsModel getDetails(@PathVariable("projectId") UUID projectId) throws NoRecordFoundException {

        return projectDetailService.getDetails(projectId);
    }
*/
        @GetMapping("/{companyId}")
        public List<ProjectDetailsModel> getDetailsby(@PathVariable("companyId")  int companyId) {

            return projectDetailService.getDetailsby(companyId);

        }


    @DeleteMapping("/{projectId}")
    public String deleteProjectDetails(@PathVariable("projectId") UUID projectId) {
        ProjectDetailsModel projectDetailsModels = projectDetailRepo.findByProjectId(projectId);

         if(projectDetailsModels!=null) {
             projectDetailRepo.delete(projectDetailsModels);
             return "Your {projectId} record is deleted successfully !!";
         } else
             return "Invalid {projectId}";


    }


    @PutMapping("/{companyId}")
    public ResponseEntity<ProjectDetailsModel> updateOrsave(@PathVariable("companyId") int companyId, @Valid @RequestBody ProjectDetailsModel projectDetailsModel){
        ProjectDetailsModel projectDetailsModel1=projectDetailRepo.findBycompanyId(companyId);
        if(projectDetailsModel1!=null) {
            projectDetailsModel1.setProjectName(projectDetailsModel.getProjectName());
            projectDetailsModel1.setClientName(projectDetailsModel.getClientName());
           // projectDetailsModel1.setProjectId(projectDetailsModel.getProjectId());
            return new ResponseEntity<>(projectDetailRepo.save(projectDetailsModel1), HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update/{projectId}")
    public ResponseEntity<ProjectDetailsModel> updateOrsaveBy(@PathVariable("projectId") UUID projectId,@Valid @RequestBody ProjectDetailsModel projectDetailsModel) {
        ProjectDetailsModel projectDetailsModel1 = projectDetailRepo.findByProjectId(projectId);

        if (projectDetailsModel1 != null) {
            projectDetailsModel1.setProjectName(projectDetailsModel.getProjectName());
            projectDetailsModel1.setClientName(projectDetailsModel.getClientName());
            projectDetailsModel1.setCompanyId(projectDetailsModel.getCompanyId());
            return new ResponseEntity<>(projectDetailRepo.save(projectDetailsModel1), HttpStatus.OK);

        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
