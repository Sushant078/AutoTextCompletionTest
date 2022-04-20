package com.example.autotextcompletionbug;

public class SampleData {

    private String name;

    private String email;

    private String designation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public SampleData() {
        this.name = "";
        this.email = "";
        this.designation = "";
    }

    public SampleData(int drawableId, String name, String email) {
        this.name = name;
        this.email = email;
    }


}
