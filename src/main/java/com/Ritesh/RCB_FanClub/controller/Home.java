package com.Ritesh.RCB_FanClub.controller;


import com.Ritesh.RCB_FanClub.dto.HomeDataDto;
import com.Ritesh.RCB_FanClub.service.HomeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Home {

    private HomeService homeService;

    public Home(HomeService home){
        this.homeService = home;
    }

    @GetMapping("/")
    public ResponseEntity<HomeDataDto> homePage(){
        HomeDataDto dto = homeService.getHomeDate();
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
