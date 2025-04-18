package com.Ritesh.RCB_FanClub.service;

import com.Ritesh.RCB_FanClub.Model.Fans;
import com.Ritesh.RCB_FanClub.Model.Matches;
import com.Ritesh.RCB_FanClub.Model.Seats;
import com.Ritesh.RCB_FanClub.dto.HomeDataDto;
import com.Ritesh.RCB_FanClub.dto.MatchDto;
import com.Ritesh.RCB_FanClub.dto.SeatsDto;
import com.Ritesh.RCB_FanClub.repository.FansRepo;
import com.Ritesh.RCB_FanClub.repository.MatchesRepo;
import com.Ritesh.RCB_FanClub.repository.SeatsRepo;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class HomeService {

    private MatchesRepo matchesRepo;
    private SeatsRepo seatsRepo;
    private FansRepo fansRepo;
    public HomeService(MatchesRepo repo, SeatsRepo seatsRepo, FansRepo fansRepo){
        this.matchesRepo = repo;
        this.seatsRepo = seatsRepo;
        this.fansRepo = fansRepo;
    }

    public HomeDataDto getHomeDate() {

        List<Matches> match = matchesRepo.getNextMatches(LocalDateTime.now(), PageRequest.of(0,6));
        Matches currMatch = match.get(0);
        MatchDto curr = new MatchDto(String.valueOf(currMatch.getMatch_no()), currMatch.getTeams(),
                                    String.valueOf(currMatch.getDateTime()),String.valueOf(currMatch.getYear()));

        List<Seats> seats = seatsRepo.getSeatsOfMatch(currMatch.getMatch_no());
        List<SeatsDto> seatDto = new ArrayList<>();
        for(Seats seat: seats){
            seatDto.add(new SeatsDto(seat.getId().getSeat_no(),seat.isBooked()));
        }

        List<MatchDto> matchDto = new ArrayList<>();
        for(int i=1; i<match.size(); i++){
            matchDto.add(new MatchDto(String.valueOf(match.get(i).getMatch_no()), match.get(i).getTeams(),
                    String.valueOf(match.get(i).getDateTime()),String.valueOf(match.get(i).getYear())));
        }
        return new HomeDataDto(seatDto,curr,matchDto) ;
    }

    public Fans getProfile(String phone) {
        Fans fan = fansRepo.findByPhone(phone);
        return (fan != null) ? fan : new Fans();
    }
}
