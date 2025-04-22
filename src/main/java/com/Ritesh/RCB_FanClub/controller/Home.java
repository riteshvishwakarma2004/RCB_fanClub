package com.Ritesh.RCB_FanClub.controller;


import com.Ritesh.RCB_FanClub.Model.BookingDetails;
import com.Ritesh.RCB_FanClub.Model.Fans;
import com.Ritesh.RCB_FanClub.dto.HomeDataDto;
import com.Ritesh.RCB_FanClub.service.HomeService;
import com.Ritesh.RCB_FanClub.dto.RegistrationDetail;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class Home {

    private HomeService homeService;

    public Home(HomeService home){
        this.homeService = home;
    }

    @GetMapping("/home")
    public String homePage(Model model){
        HomeDataDto dto = homeService.getHomeDate();
        model.addAttribute("homeDto",dto);
        return "home";
    }

    @GetMapping("/profile")
    public String profile(Model model){
       String phone = SecurityContextHolder.getContext().getAuthentication().getName();
       Fans fan = homeService.getProfile(phone);
       model.addAttribute("profileDetail", fan);
        return "profile";
    }

    @GetMapping("/registrationPage")
    public String registrationPage(){
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute RegistrationDetail detail) {
        int result = homeService.register(detail);
        if (result == 1) {
            return "success";
        }
        if(result  == 0){
            return "userExistError";
        }

        return "failed";
    }

    @GetMapping("/book")
    public String booking(@ModelAttribute BookingDetails book , Model model){
      boolean bookable =   homeService.book(book,model);
        if(bookable){
            return "bookPass";
        }
        return "bookFailed";
    }
    @PostMapping("/confirmBook")
    public String confirmBooking(@RequestParam("seat_no") String seat_no,
                                 @RequestParam("match_no") Integer match_no,
                                 Model model){
        String phone = SecurityContextHolder.getContext().getAuthentication().getName();
        homeService.confirmBook(seat_no,match_no,phone,model);
        return "ticket";
    }

//   @GetMapping("/home")
//   @ResponseBody
//   public ResponseEntity<HomeDataDto> homePage(){
//        HomeDataDto dto = homeService.getHomeDate();
//       return new ResponseEntity<>(dto, HttpStatus.OK);
//   }

}
