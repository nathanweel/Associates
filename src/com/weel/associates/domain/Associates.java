package com.weel.associates.domain;

public class Associates {

    private String name;
    private int phone;
    private String gender;
    private String details;


    // --- All Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }


    public String toString() {
        return getName() + "," + getPhone() + "," + getGender() + "," + getDetails();
    }
}
