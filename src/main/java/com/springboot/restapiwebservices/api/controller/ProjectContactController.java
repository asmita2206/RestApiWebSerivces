package com.springboot.restapiwebservices.api.controller;


import com.springboot.restapiwebservices.model.ProjectContactModel;
import com.springboot.restapiwebservices.repository.ProjectContactRepo;
import com.springboot.restapiwebservices.api.controller.request.ProjectContactRequest;
import com.springboot.restapiwebservices.service.ProjectContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ProjectContactModel insertProjectContact(@RequestBody @Valid ProjectContactRequest projectContactRequest) {

            ProjectContactModel projectContactModels = projectContactService.insertProjectContact(projectContactRequest);
         return projectContactModels;
    }


    @GetMapping("/get/{projectId}")
    public List<ProjectContactModel> getContactDetails(@PathVariable("projectId") String projectId) {

        return projectContactService.getContactDetails(projectId);


    }
    @GetMapping("/{projectContactId}")
    public ProjectContactModel getContactDetailsById(@PathVariable("projectContactId")  int projectContactId)  {

        return projectContactService.getContactDetailsById(projectContactId);
    }

    @DeleteMapping("deleteByContactId/{projectContactId}")
    public String deleteProjectContact(@PathVariable("projectContactId") int projectContactId){

          projectContactService.deleteProjectContact(projectContactId);
          return "Your {projectContactId} record is deleted successfully !!";

        }

    @PutMapping("/update/{projectContactId}")
    public ResponseEntity< ProjectContactModel> updateOrsave(@PathVariable("projectContactId") int projectContactId,@Valid @RequestBody ProjectContactRequest projectContactRequest){

        ResponseEntity <ProjectContactModel> projectContactModel1=projectContactService.updateOrsave(projectContactId,projectContactRequest);
        return projectContactModel1;

    }

    @PutMapping("/{projectId}")
    public ResponseEntity<ProjectContactModel> updateOrsaveBy(@PathVariable("projectId") String projectId, @RequestBody ProjectContactRequest projectContactRequest){

        ResponseEntity <ProjectContactModel> projectContactModel1=projectContactService.updateOrsaveBy(projectId,projectContactRequest);
        return projectContactModel1;

    }

}