package com.springboot.restapiwebservices;

import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.UUID;

public class ProjectDetailsId implements Serializable {

    private UUID clientId;
    private UUID projectId;

    public ProjectDetailsId() {
    }

    public ProjectDetailsId(UUID clientId, UUID projectId) {
        this.clientId = clientId;
        this.projectId = projectId;
    }
}
