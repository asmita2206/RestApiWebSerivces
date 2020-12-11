package com.springboot.restapiwebservices.repository;

import com.springboot.restapiwebservices.constants.StringConstants;
import com.springboot.restapiwebservices.model.ProjectDetailsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProjectDetailRepo extends JpaRepository<ProjectDetailsModel,String> {

   ProjectDetailsModel findByProjectId(String projectId);
    List<ProjectDetailsModel> findByprojectId(String projectId);

    List<ProjectDetailsModel> findByCompanyId(String companyId);
    ProjectDetailsModel findBycompanyId(String companyId);
}
