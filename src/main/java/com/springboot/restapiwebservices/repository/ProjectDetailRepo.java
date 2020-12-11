package com.springboot.restapiwebservices.repository;

import com.springboot.restapiwebservices.model.ProjectDetailsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProjectDetailRepo extends JpaRepository<ProjectDetailsModel,UUID> {

   ProjectDetailsModel findByProjectId(UUID projectId);
    List<ProjectDetailsModel> findByprojectId(UUID projectId);

    List<ProjectDetailsModel> findByCompanyId(int companyId);
    ProjectDetailsModel findBycompanyId(int companyId);
}
