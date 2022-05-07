package com.example.registrationpage;

public class UserHelperClass {
    String name, email,mobile,Aadharno,address,password;

    public UserHelperClass(){

    }

    public UserHelperClass(String name, String email, String mobile, String aadharno, String address, String password) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        Aadharno = aadharno;
        this.address = address;
        this.password = password;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAadharno() {
        return Aadharno;
    }

    public void setAadharno(String aadharno) {
        Aadharno = aadharno;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

