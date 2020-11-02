package edu.aritra.rest.jsonmapping.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("ORG")
public class Organization extends User {
    private String orgCode;
    private String businessName;
    private String officeAddress;

    public Organization(String userCode, String orgCode, String businessName, String officeAddress) {
        super(userCode, "ORG");
        this.orgCode = orgCode;
        this.businessName = businessName;
        this.officeAddress = officeAddress;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
    }
}
