package com.Ritesh.RCB_FanClub.repository;

import com.Ritesh.RCB_FanClub.Model.Fans;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FansRepo extends JpaRepository<Fans, String> {
    Fans findByPhone(String phone);
}
