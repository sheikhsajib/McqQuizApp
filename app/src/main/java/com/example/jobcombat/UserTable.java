package com.example.jobcombat;

public class UserTable {

    private String name, email, pass, referCode;

    public UserTable() {


    }

    public UserTable(String name, String email, String pass, String referCode) {
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.referCode = referCode;
    }

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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getReferCode() {
        return referCode;
    }

    public void setReferCode(String referCode) {
        this.referCode = referCode;
    }
}
