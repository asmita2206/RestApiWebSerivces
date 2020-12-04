package com.springboot.restapiwebservices.model;

import javax.persistence.*;

@Entity
@Table(name = "address_tbl")
public class AddressModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    private int addressId;
    private int projectId;
    private String addressType;
    private String line1;
    private String line2;
    private String line3;
    private long pincode;

    public AddressModel() {
    }

    public AddressModel(int addressId, int projectId, String addressType, String line1, String line2, String line3, long pincode) {
        this.addressId = addressId;
        this.projectId = projectId;
        this.addressType = addressType;
        this.line1 = line1;
        this.line2 = line2;
        this.line3 = line3;
        this.pincode = pincode;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getLine3() {
        return line3;
    }

    public void setLine3(String line3) {
        this.line3 = line3;
    }

    public long getPincode() {
        return pincode;
    }

    public void setPincode(long pincode) {
        this.pincode = pincode;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    @Override
    public String toString() {
        return "AddressModel{" +
                "addressId=" + addressId +
                ", projectId=" + projectId +
                ", addressType='" + addressType + '\'' +
                ", line1='" + line1 + '\'' +
                ", line2='" + line2 + '\'' +
                ", line3='" + line3 + '\'' +
                ", pincode=" + pincode +
                '}';
    }
}
