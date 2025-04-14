package com.Ritesh.RCB_FanClub.service;

import com.Ritesh.RCB_FanClub.Model.Matches;
import com.Ritesh.RCB_FanClub.Model.SeatId;
import com.Ritesh.RCB_FanClub.Model.Seats;
import com.Ritesh.RCB_FanClub.repository.MatchesRepo;
import com.Ritesh.RCB_FanClub.repository.SeatsRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    private MatchesRepo matchesRepo;
    private SeatsRepo seatsRepo;

    public AdminService(MatchesRepo matches, SeatsRepo seats) {
        this.matchesRepo = matches;
        this.seatsRepo = seats;
    }

    public Matches addMatch(Matches match) {
        matchesRepo.save(match);
        addSeatsForMatch(match.getMatch_no());
        return match;
    }

    public void addSeatsForMatch(Integer match_no) {

            for (int i = 1; i <= 20; i++) {
                SeatId id = new SeatId(match_no,String.valueOf(i));
                seatsRepo.save(new Seats(id, false));
            }

    }

    public Matches removeMatch(Integer no) {
        Optional<Matches> match = matchesRepo.findById(no);
        matchesRepo.deleteById(no);
        removeSeats(no);
        return match.get();
    }
    public void removeSeats(Integer no){
        seatsRepo.removeByMatchNo(no);
    }

    public void removeSeason() {
        matchesRepo.deleteAll();
        seatsRepo.deleteAll();
    }
}