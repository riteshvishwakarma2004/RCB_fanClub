package com.Ritesh.RCB_FanClub.controller;

import com.Ritesh.RCB_FanClub.Model.Fans;
import com.Ritesh.RCB_FanClub.service.FansService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FansController {

    private FansService service;

    public FansController(FansService service){
        this.service = service;
    }

//    @PostMapping("/register")
//    public ResponseEntity<String> register(@RequestBody Fans fan){
//        service.register(fan);
//
//        return new ResponseEntity<>("Added Successfully", HttpStatus.CREATED);
//    }
//
//    @GetMapping("/dashboard")
//    public ResponseEntity<Fans> getProfile(){
//        System.out.println("reaching profile");
//        String phone = SecurityContextHolder.getContext().getAuthentication().getName();
//        System.out.println(phone);
//        Fans fan = service.getProfile(phone);
//        return new ResponseEntity<>(fan,HttpStatus.OK);
//    }
 }
