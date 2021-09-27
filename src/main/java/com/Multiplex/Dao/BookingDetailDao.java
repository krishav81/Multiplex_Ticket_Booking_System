package com.Multiplex.Dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Multiplex.Model.BookingDetail;
@Repository
public interface BookingDetailDao extends JpaRepository<BookingDetail,Integer> {

}