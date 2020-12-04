package com.springboot.restapiwebservices.controller;


import com.springboot.restapiwebservices.model.ProjectContactModel;
import com.springboot.restapiwebservices.model.ProjectDetailsModel;
import com.springboot.restapiwebservices.repository.ProjectContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectContactController {

    @Autowired
    ProjectContactRepo projectContactRepo;

    @PostMapping("/saveContact")
    public String insertProjectContact(@RequestBody ProjectContactModel projectContactModel) {
        projectContactRepo.save(projectContactModel);
        return "your record is saved successfully !!";
    }

    @GetMapping("/getAllContacts")
    public List<ProjectContactModel> getAllContacts() {
        return (List<ProjectContactModel>) projectContactRepo.findAll();
    }

    @GetMapping("/getContactByProjectId/{projectId}")
    public List<ProjectContactModel> getContactDetails(@PathVariable("projectId")  int projectId) {

        return projectContactRepo.findByProjectId(projectId);
    }



    @DeleteMapping("deleteByContactId/{contactId}")
    public String deleteProjectDetails(@PathVariable("contactId") int contactId){
        ProjectContactModel projectContactModel=projectContactRepo.getOne(contactId);

        projectContactRepo.delete(projectContactModel);
        return "Your {contactId} record is deleted successfully !!";
    }


    @PutMapping("/updateProjectContact")
    public List<ProjectContactModel> saveOrupdateProjectContact(@RequestBody List<ProjectContactModel> projectContactModel) {
        projectContactRepo.saveAll(projectContactModel);
        return projectContactModel;
    }

    @PutMapping("/updateByContactId/{projectContactId}")
    public ProjectContactModel updateOrsave(@PathVariable("projectContactId") int projectContactId,@RequestBody ProjectContactModel projectContactModel){

        return projectContactRepo.save(projectContactModel);
    }

    @PutMapping("/updateContactByProjectId/{projectId}")
    public ProjectContactModel updateOrsaveBy(@PathVariable("projectId") int projectId,@RequestBody ProjectContactModel projectContactModel){

        return projectContactRepo.save(projectContactModel);
    }

}