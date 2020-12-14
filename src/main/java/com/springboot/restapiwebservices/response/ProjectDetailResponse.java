package com.springboot.restapiwebservices.response;

public class ProjectDetailResponse {

    private String projectId;
    private boolean projectIdDeleted;

    public ProjectDetailResponse(String projectId, boolean projectIdDeleted) {
        this.projectId = projectId;
        this.projectIdDeleted = projectIdDeleted;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public boolean isProjectIdDeleted() {
        return projectIdDeleted;
    }

    public void setProjectIdDeleted(boolean projectIdDeleted) {
        this.projectIdDeleted = projectIdDeleted;
    }
}
