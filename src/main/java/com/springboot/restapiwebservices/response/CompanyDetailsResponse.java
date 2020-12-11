package com.springboot.restapiwebservices.response;

import lombok.Data;

@Data
public class CompanyDetailsResponse {

    String companyId;
    String companyAddress;
    String companyName;
}
