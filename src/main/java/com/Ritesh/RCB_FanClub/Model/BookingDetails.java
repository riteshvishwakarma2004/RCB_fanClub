package com.Ritesh.RCB_FanClub.Model;

import org.springframework.stereotype.Component;

@Component
public class BookingDetails {
    private Integer match_no;
    private String seat_no;
    private boolean isBooked;


    public BookingDetails(Integer match_no, String seat_no, boolean isBooked) {
        this.match_no = match_no;
        this.seat_no = seat_no;
        this.isBooked = isBooked;
    }

    public BookingDetails() {
    }

    public Integer getMatch_no() {
        return match_no;
    }

    public void setMatch_no(Integer match_no) {
        this.match_no = match_no;
    }

    public String getSeat_no() {
        return seat_no;
    }

    public void setSeat_no(String seat_no) {
        this.seat_no = seat_no;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

}
