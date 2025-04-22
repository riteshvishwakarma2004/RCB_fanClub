package com.Ritesh.RCB_FanClub.service;

import com.Ritesh.RCB_FanClub.Model.*;
import com.Ritesh.RCB_FanClub.dto.HomeDataDto;
import com.Ritesh.RCB_FanClub.dto.MatchDto;
import com.Ritesh.RCB_FanClub.dto.RegistrationDetail;
import com.Ritesh.RCB_FanClub.dto.SeatsDto;
import com.Ritesh.RCB_FanClub.repository.FansRepo;
import com.Ritesh.RCB_FanClub.repository.MatchesRepo;
import com.Ritesh.RCB_FanClub.repository.SeatsRepo;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HomeService {

    private final MatchesRepo matchesRepo;
    private final SeatsRepo seatsRepo;
    private final FansRepo fansRepo;
    private final PasswordEncoder encoder;
    public HomeService(MatchesRepo repo, SeatsRepo seatsRepo, FansRepo fansRepo, PasswordEncoder encoder){
        this.matchesRepo = repo;
        this.seatsRepo = seatsRepo;
        this.fansRepo = fansRepo;
        this.encoder = encoder;
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

    public int register(RegistrationDetail detail) {
        String phone = detail.getPhone();
                if(fansRepo.existsById(phone)){
                    return 0;
                }
        Fans fan = new Fans();
        fan.setName(detail.getName());
        fan.setPhone(detail.getPhone());
        fan.setPassword(encoder.encode(detail.getPassword()));
        fan.setBalance(1000.0);
        fan.setLastSeatDetail("N/A");
        try{
        fansRepo.save(fan);
        return 1;
    } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return 2;

    }

    public boolean book(BookingDetails book , Model model) {
        String phone = SecurityContextHolder.getContext().getAuthentication().getName();
        Fans fan = fansRepo.findByPhone(phone);
        double balance = fan.getBalance();
        boolean bookable = false;
        if(balance >= 500.0){
            bookable = true;
        }
        model.addAttribute("name",fan.getName());
        model.addAttribute("phone", fan.getPhone());
        model.addAttribute("currentBalance", fan.getBalance());
        model.addAttribute("bookable",bookable);
        model.addAttribute("seat_no" , book.getSeat_no());
        model.addAttribute("match_no",book.getMatch_no());
        return bookable;
    }

    @Transactional
    public void confirmBook(String seat_no,
                            Integer match_no,
                            String phone,
                            Model model) {
        SeatId id = new SeatId(match_no,seat_no);
        System.out.println("before saving seat detail");
        seatsRepo.save(new Seats(id, true));

        Fans fan = fansRepo.findByPhone(phone);
        System.out.println("before balance update");
        int rows = fansRepo.updateBalance((fan.getBalance()-499.0), phone);

        Optional<Matches> match = matchesRepo.findById(match_no);
        Matches curr = match.get();
        System.out.println("before updatelastseatdetail");
        int row = fansRepo.updateLastSeatDetail(("Match no. "+curr.getMatch_no() +" "+ curr.getTeams()), phone);
        model.addAttribute("matchNo",curr.getMatch_no());
        model.addAttribute("teams",curr.getTeams());
        model.addAttribute("year",curr.getYear());
        model.addAttribute("datetime",curr.getDateTime());
        model.addAttribute("name",fan.getName());
        model.addAttribute("phone",fan.getPhone());
        model.addAttribute("seatNo",seat_no);
        model.addAttribute("price", "499/-");
    }
}
