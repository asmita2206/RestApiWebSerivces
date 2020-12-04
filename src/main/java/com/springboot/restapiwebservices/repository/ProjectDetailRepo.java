package com.springboot.restapiwebservices.repository;

import com.springboot.restapiwebservices.model.ProjectDetailsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProjectDetailRepo extends JpaRepository<ProjectDetailsModel,UUID> {

    List<ProjectDetailsModel> findByProjectId(UUID projectId);

    List<ProjectDetailsModel> findByCompanyId(int companyId);
}
