package com.springboot.restapiwebservices.repository;

import com.springboot.restapiwebservices.constants.StringConstants;
import com.springboot.restapiwebservices.model.ProjectContactModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectContactRepo extends JpaRepository<ProjectContactModel,Integer> {

    List<ProjectContactModel> findByProjectId(String projectId);
    ProjectContactModel findByprojectId(String projectId);
    ProjectContactModel findByProjectContactId(int projectContactId);
}
