package com.springboot.restapiwebservices.model;

import com.springboot.restapiwebservices.ProjectDetailsId;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.annotation.Generated;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.UUID;

@Entity
@IdClass(ProjectDetailsId.class)
@Table(name = "project_details")
public class ProjectDetailsModel {

    @Id
  /*  @GenericGenerator(name = "uuid1",strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "uuid1")
    @Column(name = "projectId",updatable = false,nullable = false)*/
   // @GeneratedValue(strategy = GenerationType.AUTO)
    private String projectId;
    @Id
    private String clientId;
   // @ApiModelProperty(required = true)

    private String companyId;
    @ApiModelProperty(required = true)
    @NotNull
    private String projectName;
    private String clientName;


    public ProjectDetailsModel() {
    }

    public ProjectDetailsModel(String projectId, String clientId, String companyId, String projectName, String clientName) {
        this.projectId = projectId;
        this.clientId = clientId;
        this.companyId = companyId;
        this.projectName = projectName;
        this.clientName = clientName;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
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
