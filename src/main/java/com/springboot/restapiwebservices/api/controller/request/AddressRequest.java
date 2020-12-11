package com.springboot.restapiwebservices.api.controller.request;


public class AddressRequest {

     String addressType;
     String line1;
     String line2;
     String line3;
    long pincode;

    public String getAddressType() {
        return addressType;
    }

    public String getLine1() {
        return line1;
    }

    public String getLine2() {
        return line2;
    }

    public String getLine3() {
        return line3;
    }

    public long getPincode() {
        return pincode;
    }
}
