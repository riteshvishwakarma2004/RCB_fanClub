package com.Ritesh.RCB_FanClub.service;

import com.Ritesh.RCB_FanClub.Model.AppUser;
import com.Ritesh.RCB_FanClub.Model.CustomUserDetails;
import com.Ritesh.RCB_FanClub.Model.Fans;
import com.Ritesh.RCB_FanClub.repository.FansRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private FansRepo repo;

    public MyUserDetailsService(FansRepo repo){
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
        Fans fan = repo.findByPhone(phone);
        if(fan == null){
            throw new UsernameNotFoundException("user not found");
        }
        AppUser user = new AppUser();
        user.setPhone(fan.getPhone());
        user.setPassword(fan.getPassword());


        return new CustomUserDetails(user);
    }
}
