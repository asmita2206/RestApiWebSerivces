package com.springboot.restapiwebservices.controller;


import com.springboot.restapiwebservices.model.CompanyDetailsModel;
import com.springboot.restapiwebservices.model.ProjectContactModel;
import com.springboot.restapiwebservices.model.ProjectDetailsModel;
import com.springboot.restapiwebservices.repository.ProjectContactRepo;
import com.springboot.restapiwebservices.service.NoRecordFoundException;
import com.springboot.restapiwebservices.service.ProjectContactService;
import com.springboot.restapiwebservices.service.ProjectDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rest/ProjectContact")
public class ProjectContactController {

    @Autowired
    ProjectContactRepo projectContactRepo;
    @Autowired
    ProjectContactService projectContactService;

    @PostMapping
    public String insertProjectContact(@RequestBody @Valid List<ProjectContactModel> projectContactModel) {
        try {
            List<ProjectContactModel> projectContactModels = projectContactService.insertProjectContact(projectContactModel);
            return "your record is saved successfully !!";
        }catch (Exception e){
            new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            return "{projectId} ,{contactNumber},{contactEmail} required !!";
        }

    }


    @GetMapping("/{projectId}")
    public List<ProjectContactModel> getContactDetails(@PathVariable("projectId")  int projectId) {

        return projectContactService.getContactDetails(projectId);


    }
    /*@GetMapping("/{projectContactId}")
    public ProjectContactModel getContactDetailsById(@PathVariable("projectContactId")  int projectContactId)  {

        return projectContactService.getContactDetailsById(projectContactId);
    }
*/
    @DeleteMapping("deleteByContactId/{projectContactId}")
    public String deleteProjectContact(@PathVariable("projectContactId") int projectContactId){

        ProjectContactModel projectContactModel=projectContactRepo.findByProjectContactId(projectContactId);
        if(projectContactModel!=null) {
            projectContactRepo.delete(projectContactModel);
            return "Your {projectContactId} record is deleted successfully !!";
        }
        else

            return "Invalid {projectContactId}";

    }


    @PutMapping("/update/{projectContactId}")
    public ResponseEntity< ProjectContactModel> updateOrsave(@PathVariable("projectContactId") int projectContactId,@Valid @RequestBody ProjectContactModel projectContactModel){
        ProjectContactModel projectContactModel1=projectContactRepo.findByProjectContactId(projectContactId);

      if(projectContactModel1!=null) {
          projectContactModel1.setContactEmail(projectContactModel.getContactEmail());
          projectContactModel1.setContactName(projectContactModel.getContactName());
          projectContactModel1.setContactNumber(projectContactModel.getContactNumber());
          projectContactModel1.setContactType(projectContactModel.getContactType());
          projectContactModel1.setProjectId(projectContactModel.getProjectId());
          return new ResponseEntity<>(projectContactRepo.save(projectContactModel1), HttpStatus.OK);
      }else
          return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{projectId}")
    public ResponseEntity<ProjectContactModel> updateOrsaveBy(@PathVariable("projectId") int projectId, @RequestBody ProjectContactModel projectContactModel){
     ProjectContactModel projectContactModel1=projectContactRepo.findByprojectId(projectId);
     if(projectContactModel1!=null) {
         projectContactModel1.setContactEmail(projectContactModel.getContactEmail());
         projectContactModel1.setContactName(projectContactModel.getContactName());
         projectContactModel1.setContactNumber(projectContactModel.getContactNumber());
         projectContactModel1.setContactType(projectContactModel.getContactType());
        // projectContactModel1.setProjectId(projectContactModel.getProjectId());
         return new ResponseEntity<>(projectContactRepo.save(projectContactModel1), HttpStatus.OK);
     } else
         return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}