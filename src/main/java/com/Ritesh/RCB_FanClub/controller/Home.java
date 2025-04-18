package com.Ritesh.RCB_FanClub.controller;


import com.Ritesh.RCB_FanClub.Model.Fans;
import com.Ritesh.RCB_FanClub.dto.HomeDataDto;
import com.Ritesh.RCB_FanClub.service.HomeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

//   @GetMapping("/home")
//   @ResponseBody
//   public ResponseEntity<HomeDataDto> homePage(){
//        HomeDataDto dto = homeService.getHomeDate();
//       return new ResponseEntity<>(dto, HttpStatus.OK);
//   }

}
