package com.Ritesh.RCB_FanClub.repository;

import com.Ritesh.RCB_FanClub.Model.SeatId;
import com.Ritesh.RCB_FanClub.Model.Seats;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatsRepo extends JpaRepository<Seats, SeatId> {

    @Modifying
    @Transactional
    @Query("DELETE FROM Seats s WHERE s.id.match_no = :no")
    void removeByMatchNo(@Param("no") Integer no);


    @Query("SELECT s FROM Seats s where s.id.match_no = :match_no")
    List<Seats> getSeatsOfMatch(@Param("match_no") Integer matchNo);
}
