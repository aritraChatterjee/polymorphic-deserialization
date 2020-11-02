package edu.aritra.rest.jsonmapping.dto;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "userType"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Individual.class, name = "IND"),
        @JsonSubTypes.Type(value = Organization.class, name = "ORG")
})
public abstract class User {
    private String userCode;
    private String userType;

    public User() {
        // default constructor
    }

    public User(String userCode, String userType) {
        this.userCode = userCode;
        this.userType = userType;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
