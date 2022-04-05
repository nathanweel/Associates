package com.weel.associates.domain;

public class Associates {

    private String name;
    private String phone;
    private String email;
    private String details;


    // --- All Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }


    public String toString() {
        return getName() + "," + getPhone() + "," + getEmail() + "," + getDetails();
    }
}
