package com.Ritesh.RCB_FanClub.service;


import com.Ritesh.RCB_FanClub.Model.Fans;

import com.Ritesh.RCB_FanClub.repository.FansRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class FansService {

    private FansRepo repo;
    private PasswordEncoder passwordEncoder;

    public FansService(FansRepo repo, PasswordEncoder encoder){
        this.repo = repo;
        this.passwordEncoder = encoder;
    }

    public void register(Fans fan) {
        fan.setBalance(1000.0);
        fan.setPassword(passwordEncoder.encode(fan.getPassword()));
        fan.setLastSeatDetail("N/A");
        repo.save(fan);
    }

    public Fans getProfile(String phone) {
        return repo.findByPhone(phone);
    }
}
