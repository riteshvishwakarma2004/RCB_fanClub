package com.Ritesh.RCB_FanClub.Model;


import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode
public class SeatId implements Serializable {
    private Integer match_no;
    private  String seat_no;

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

    public SeatId(Integer match_no, String seat_no) {
        this.match_no = match_no;
        this.seat_no = seat_no;
    }

    public SeatId() {
    }
}
