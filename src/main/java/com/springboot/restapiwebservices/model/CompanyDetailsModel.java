package com.springboot.restapiwebservices.model;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.NotFound;
import org.springframework.data.annotation.TypeAlias;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "company_details")
public class CompanyDetailsModel {

    @Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
    private String companyId;
    //@NotBlank(message = "company name can not be empty !!")
   // @ApiModelProperty(notes = "Required Company name",value = "Company Name",required = true)
    @NotNull(message = "please add Company Name")
    private String companyName;
    private String companyAddress;


    public CompanyDetailsModel() {
    }

    public CompanyDetailsModel(String companyId, @NotNull(message = "please add Company Name") String companyName, String companyAddress) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.companyAddress = companyAddress;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    @Override
    public String toString() {
        return "CompanyDetailsModel{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", companyAddress='" + companyAddress + '\'' +
                '}';
    }
}
