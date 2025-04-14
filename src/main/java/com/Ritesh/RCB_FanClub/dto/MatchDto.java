package com.Ritesh.RCB_FanClub.dto;

public class MatchDto {
    private String match_no;
    private String teams;
    private String dateTime;
    private String year;

    public String getMatch_no() {
        return match_no;
    }

    public void setMatch_no(String match_no) {
        this.match_no = match_no;
    }

    public String getTeams() {
        return teams;
    }

    public void setTeams(String teams) {
        this.teams = teams;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public MatchDto(String match_no, String teams, String dateTime, String year) {
        this.match_no = match_no;
        this.teams = teams;
        this.dateTime = dateTime;
        this.year = year;
    }

    public MatchDto() {
    }
}
