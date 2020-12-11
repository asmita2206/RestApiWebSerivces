package com.springboot.restapiwebservices;

import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.UUID;

public class ProjectDetailsId implements Serializable {

    private String clientId;
    private String projectId;

    public ProjectDetailsId() {
    }

    public ProjectDetailsId(String clientId, String projectId) {
        this.clientId = clientId;
        this.projectId = projectId;
    }
}
