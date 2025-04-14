package com.Ritesh.RCB_FanClub.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;


import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Matches {
    @Id
    @Column(nullable = false, unique = true)
    private Integer match_no;

    @Column(nullable = false)
    private String teams;

    @Column(nullable = false)
    private LocalDateTime dateTime;

    @Column(nullable = false)
    private Integer year;

    public Integer getMatch_no() {
        return match_no;
    }

    public void setMatch_no(Integer match_no) {
        this.match_no = match_no;
    }

    public String getTeams() {
        return teams;
    }

    public void setTeams(String teams) {
        this.teams = teams;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Matches(Integer match_no, String teams, LocalDateTime dateTime, Integer year) {
        this.match_no = match_no;
        this.teams = teams;
        this.dateTime = dateTime;
        this.year = year;
    }

    public Matches() {
    }
}
