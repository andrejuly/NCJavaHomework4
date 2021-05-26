package com.company.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class SearchedUser {

    @Pattern(regexp = "[a-zA-Z]{2,20}")
    @NotBlank
    private String firstName;

    @Pattern(regexp = "[a-zA-Z]{2,20}")
    @NotBlank
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
