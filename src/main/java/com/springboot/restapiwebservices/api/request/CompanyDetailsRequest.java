package com.springboot.restapiwebservices.api.request;

import lombok.Data;

@Data
public class CompanyDetailsRequest {

    String companyName;
    String comapnyAddress;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getComapnyAddress() {
        return comapnyAddress;
    }

    public void setComapnyAddress(String comapnyAddress) {
        this.comapnyAddress = comapnyAddress;
    }
}
