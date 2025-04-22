package com.Ritesh.RCB_FanClub.repository;

import com.Ritesh.RCB_FanClub.Model.Fans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FansRepo extends JpaRepository<Fans, String> {
    Fans findByPhone(String phone);

    @Modifying
    @Query("UPDATE Fans f SET f.balance = :v WHERE f.phone = :phone")
    int updateBalance(@Param("v") double v, @Param("phone") String phone);

    @Modifying
    @Query("UPDATE Fans f SET f.lastSeatDetail = :s WHERE f.phone = :phone")
    int updateLastSeatDetail(@Param("s") String s, @Param("phone") String phone);
}
