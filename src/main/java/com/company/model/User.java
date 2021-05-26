package com.company.model;

import javax.validation.constraints.*;

public class User {

    @Pattern(regexp = "[a-zA-Z]{2,20}")
    @NotBlank
    private String lastName;

    @Pattern(regexp = "[a-zA-Z]{2,20}")
    @NotBlank
    private String firstName;

    @Pattern(regexp = "[a-zA-Z]{2,20}")
    @NotBlank
    private String middleName;

    @Min(14)
    @Max(70)
    @NotNull
    private int age;

    private double salary;

    @Email
    private String email;

    @Pattern(regexp = "[a-zA-Z]{2,20}")
    private String companyName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    
    @Override
    public String toString() {
        return firstName + "|" + lastName + "|" + middleName + "|" + age + "|" + salary +
                "|" + email + "|" + companyName;
    }

}
