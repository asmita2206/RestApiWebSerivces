package com.springboot.restapiwebservices.controller;

import com.fasterxml.uuid.Generators;
import com.springboot.restapiwebservices.model.CompanyDetailsModel;
import com.springboot.restapiwebservices.model.ProjectContactModel;
import com.springboot.restapiwebservices.model.ProjectDetailsModel;
import com.springboot.restapiwebservices.repository.ProjectDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

@RestController
public class ProjectDetailController {

    @Autowired
    ProjectDetailRepo projectDetailRepo;

   /* @Autowired
    ProjectContactController projectContactController;
*/
    @PostMapping("/saveDetails")
    public String insertProjectDetails(@RequestBody ProjectDetailsModel projectDetailsModel) {

        projectDetailRepo.save(projectDetailsModel);
        return "your record is saved successfully !!";
    }

    @GetMapping("/getAllDetails")
    public List<ProjectDetailsModel> getAllDetails() {
        return (List<ProjectDetailsModel>) projectDetailRepo.findAll();
    }

    @GetMapping("/getByProjectId/{projectId}")
    public List<ProjectDetailsModel> getDetails(@PathVariable("projectId") UUID projectId) {

        return projectDetailRepo.findByProjectId(projectId);
    }

        @GetMapping("/getBycompanyId/{companyId}")
        public List<ProjectDetailsModel> getDetailsby(@PathVariable("companyId")  int companyId) {

            return projectDetailRepo.findByCompanyId(companyId);


        }


    @DeleteMapping("deleteByProjectId/{projectId}")
    public String deleteProjectDetails(@PathVariable("projectId") UUID projectId){
     ProjectDetailsModel projectDetailsModel=projectDetailRepo.getOne(projectId);

        projectDetailRepo.delete(projectDetailsModel);
        return "Your {projectId} record is deleted successfully !!";
    }


    @PutMapping("/updateProjectDetails")
    public List<ProjectDetailsModel> saveOrupdateProjectDetails(@RequestBody List<ProjectDetailsModel> projectDetailsModels) {
        projectDetailRepo.saveAll(projectDetailsModels);
        return projectDetailsModels;
    }

    @PutMapping("/updateProjectByCompanyId/{companyId}")
    public ProjectDetailsModel updateOrsave(@PathVariable("companyId") int companyId,@RequestBody ProjectDetailsModel projectDetailsModel){

        return projectDetailRepo.save(projectDetailsModel);
    }

    @PutMapping("/updateByProjectId/{projectId}")
    public ProjectDetailsModel updateOrsaveBy(@PathVariable("projectId") UUID projectId,@RequestBody ProjectDetailsModel projectDetailsModel){

        return projectDetailRepo.save(projectDetailsModel);
    }

}
