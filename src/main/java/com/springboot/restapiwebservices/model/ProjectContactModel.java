package com.springboot.restapiwebservices.model;

import com.springboot.restapiwebservices.ProjectDetailsId;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(name = "project_contact")
public class ProjectContactModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int projectContactId;
    @ApiModelProperty(required = true)
    @NotNull
    private String projectId;
    private String contactName;
    @ApiModelProperty(required = true)
    @NotNull
    private long contactNumber;
    @ApiModelProperty(required = true)
    @NotNull
    private String contactEmail;
    private String contactType;

    public ProjectContactModel() {
    }

    public ProjectContactModel(int projectContactId, String projectId, String contactName, long contactNumber, String contactEmail, String contactType) {
        this.projectContactId = projectContactId;
        this.projectId = projectId;
        this.contactName = contactName;
        this.contactNumber = contactNumber;
        this.contactEmail = contactEmail;
        this.contactType = contactType;
    }

    public int getProjectContactId() {
        return projectContactId;
    }

    public void setProjectContactId(int projectContactId) {
        this.projectContactId = projectContactId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    @Override
    public String toString() {
        return "ProjectContactModel{" +
                "projectContactId=" + projectContactId +
                ", projectId=" + projectId +
                ", contactName='" + contactName + '\'' +
                ", contactNumber=" + contactNumber +
                ", contactEmail='" + contactEmail + '\'' +
                ", contactType='" + contactType + '\'' +
                '}';
    }


}
