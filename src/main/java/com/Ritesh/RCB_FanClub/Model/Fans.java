package com.Ritesh.RCB_FanClub.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
public class Fans {
    @Id
    @Column(nullable = false, length = 10)
    private String phone;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double balance;

    @Column(nullable = false)
    private String password;


    private String lastSeatDetail;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastSeatDetail() {
        return lastSeatDetail;
    }

    public void setLastSeatDetail(String lastSeatDetail) {
        this.lastSeatDetail = lastSeatDetail;
    }

    public Fans(String phone, String name, Double balance, String password, String lastSeatDetail) {
        this.phone = phone;
        this.name = name;
        this.balance = balance;
        this.password = password;
        this.lastSeatDetail = lastSeatDetail;
    }

    public Fans() {
    }
}
