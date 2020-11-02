package edu.aritra.rest.jsonmapping.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("IND")
public class Individual extends User {
    private String name;
    private String residentialAddress;

    public Individual(String userCode, String name, String residentialAddress) {
        super(userCode, "IND");
        this.name = name;
        this.residentialAddress = residentialAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResidentialAddress() {
        return residentialAddress;
    }

    public void setResidentialAddress(String residentialAddress) {
        this.residentialAddress = residentialAddress;
    }
}
