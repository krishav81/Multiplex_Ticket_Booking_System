package com.Multiplex.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Multiplex.Model.Booking;
@Repository
public interface BookingDao extends JpaRepository<Booking, Integer> {


}
