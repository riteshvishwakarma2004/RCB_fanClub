package com.Ritesh.RCB_FanClub.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class AppUser {
    @Id
    private String phone;
    private String password;

    public AppUser(String phone, String password) {
        this.phone = phone;
        this.password = password;
    }

    public AppUser() {
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

}
