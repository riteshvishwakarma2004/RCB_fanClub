package com.Ritesh.RCB_FanClub.dto;

import com.Ritesh.RCB_FanClub.Model.Seats;

import java.util.ArrayList;
import java.util.List;

public class HomeDataDto {
   private List<SeatsDto> seatsList;
   private MatchDto currMatch;
   private List<MatchDto> nextMatches;

    public List<SeatsDto> getSeatsList() {
        return seatsList;
    }

    public void setSeatsList(List<SeatsDto> seatsList) {
        this.seatsList = seatsList;
    }

    public MatchDto getCurrMatch() {
        return currMatch;
    }

    public void setCurrMatch(MatchDto currMatch) {
        this.currMatch = currMatch;
    }

    public List<MatchDto> getNextMatches() {
        return nextMatches;
    }

    public void setNextMatches(List<MatchDto> nextMatches) {
        this.nextMatches = nextMatches;
    }

    public HomeDataDto(List<SeatsDto> seatsList, MatchDto currMatch, List<MatchDto> nextMatches) {
        this.seatsList = seatsList;
        this.currMatch = currMatch;
        this.nextMatches = nextMatches;
    }

    public HomeDataDto() {
    }
}
