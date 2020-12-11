package com.springboot.restapiwebservices.api.controller.request;

public class ProjectContactRequest {

    String contactName;
    long contactNumber;
    String contactEmail;
    String contactType;

    public String getContactName() {
        return contactName;
    }

    public long getContactNumber() {
        return contactNumber;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public String getContactType() {
        return contactType;
    }
}
