package com.Ritesh.RCB_FanClub.dto;

public class SeatsDto {
    private String seatNo;
    private Boolean isBooked;

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public Boolean getBooked() {
        return isBooked;
    }

    public void setBooked(Boolean booked) {
        isBooked = booked;
    }

    public SeatsDto(String seatNo, Boolean isBooked) {
        this.seatNo = seatNo;
        this.isBooked = isBooked;
    }

    public SeatsDto() {
    }
}
