package com.Ritesh.RCB_FanClub.dto;

public class RegistrationDetail {
    private String name;
    private String phone;
    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RegistrationDetail(String name, String phone, String password) {
        this.name = name;
        this.phone = phone;
        this.password = password;
    }

    public RegistrationDetail() {
    }
}
