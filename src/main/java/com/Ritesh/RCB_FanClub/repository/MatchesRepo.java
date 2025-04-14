package com.Ritesh.RCB_FanClub.repository;

import com.Ritesh.RCB_FanClub.Model.Matches;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MatchesRepo extends JpaRepository<Matches, Integer> {

    @Query("SELECT m FROM Matches m where m.dateTime > :dateTime ORDER BY m.dateTime ASC")
    List<Matches> getNextMatches(@Param("dateTime") LocalDateTime dateTime, Pageable pageble);
}
