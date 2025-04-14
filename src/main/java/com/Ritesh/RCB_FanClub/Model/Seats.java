package com.Ritesh.RCB_FanClub.Model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Builder
public class Seats {

    @EmbeddedId
    private SeatId id; //composite key

    @Column(nullable = false)
    private boolean isBooked; //true if booked

    public Seats(SeatId id, boolean isBooked) {
        this.id = id;
        this.isBooked = isBooked;
    }

    public Seats() {
    }

    public SeatId getId() {
        return id;
    }

    public void setId(SeatId id) {
        this.id = id;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }
}
