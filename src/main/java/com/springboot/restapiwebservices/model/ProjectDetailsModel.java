package com.springboot.restapiwebservices.model;

import com.springboot.restapiwebservices.ProjectDetailsId;
import org.hibernate.annotations.GenericGenerator;

import javax.annotation.Generated;
import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.UUID;

@Entity
@IdClass(ProjectDetailsId.class)
@Table(name = "project_details")
public class ProjectDetailsModel {

    @Id
    @GenericGenerator(name = "uuid1",strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "uuid1")
    @Column(name = "projectId",updatable = false,nullable = false)
   // @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID projectId;
    @Id
    @GenericGenerator(name = "uuid2",strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "uuid2")
    @Column(name = "clientId",updatable = false,nullable = false)
    private UUID clientId;

    private int companyId;
    private String projectName;
    private String clientName;


    public ProjectDetailsModel() {
    }

    public ProjectDetailsModel(UUID projectId, UUID clientId, int companyId, String projectName, String clientName) {
        this.projectId = projectId;
        this.clientId = clientId;
        this.companyId = companyId;
        this.projectName = projectName;
        this.clientName = clientName;
    }

    public UUID getProjectId() {
        return projectId;
    }

    public void setProjectId(UUID projectId) {
        this.projectId = projectId;
    }

    public UUID getClientId() {
        return clientId;
    }

    public void setClientId(UUID clientId) {
        this.clientId = clientId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    @Override
    public String toString() {
        return "ProjectDetailsModel{" +
                "projectId=" + projectId +
                ", clientId=" + clientId +
                ", companyId=" + companyId +
                ", projectName='" + projectName + '\'' +
                ", clientName='" + clientName + '\'' +
                '}';
    }
}
