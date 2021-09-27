package com.Multiplex.Dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Multiplex.Model.SeatType;
@Repository
public interface SeatTypeDao extends JpaRepository<SeatType,Integer> {

}
