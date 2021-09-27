package com.Multiplex.Services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.*;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Multiplex.Dao.BookingDao;
import com.Multiplex.Dao.BookingDetailDao;
import com.Multiplex.Dao.HallCapacityDao;
import com.Multiplex.Dao.HallDao;
import com.Multiplex.Dao.ShowsDao;
import com.Multiplex.Model.Booking;
import com.Multiplex.Model.BookingDetail;
import com.Multiplex.Model.Hall;
import com.Multiplex.Model.HallCapacity;
import com.Multiplex.Model.SeatType;
import com.Multiplex.Model.Shows;
import com.Multiplex.Model.Ticket;
import com.Multiplex.Model.Users;
@Service
public class BookingServiceImpl implements BookingService {
	@Autowired
	private HallService hallService;
	@Autowired
	private BookingDao bookingDao;
	@Autowired
	private ShowsDao showDao;
	@Autowired
	private HallDao hallDao;
	@Autowired
	private HallCapacityDao hallCapacityDao;
	@Autowired
	private BookingDetailDao bookingDetailDao;
	@Override
	public Booking getBooking(long bookingId) {
		return bookingDao.getById((int) bookingId);
	}
	@Override
	public String addBooking(Ticket ticket) {
		int hallId=ticket.getShowID();
		List<HallCapacity> hallCapacity=hallCapacityDao.findAll();
		for(HallCapacity h: hallCapacity)
		{
		if(ticket.getSeatTypeId()==h.getSeatType().getSeatTypeId()||h.getSeatCount()>=ticket.getNoOfSeats())
		{
			int seatCnt=h.getSeatCount()-ticket.getNoOfSeats();
			h.setSeatCount(seatCnt);
		Booking booking =new Booking();
		booking.setBookedDate(ticket.getBookedDate());
		booking.setShowDate(ticket.getShowDate());
		booking.setBookingId(ticket.getBookingID());
		Users user =new Users();
		user.setUserId(ticket.getUserId());
		booking.setUsername(user);
		Shows show=new Shows();
		show.setShowId(ticket.getShowID());
		booking.setShow(show);
		bookingDao.save(booking);
		BookingDetail bookingDetail=new BookingDetail();
		float x=h.getSeatType().getSeatFare();
		float cost=x*ticket.getNoOfSeats();
		bookingDetail.setTotalCost((int)cost);
		bookingDetail.setBooking(booking);
		bookingDetail.setNoOfSeats(ticket.getNoOfSeats());
		SeatType seat=h.getSeatType();
		bookingDetail.setSeat(seat);
		bookingDetailDao.save(bookingDetail);
		return "Booking Done Successfully";
		}
		}
		return "Booking Not Successful";
	}
	
	@Override
	public String deleteBooking(long bookingid) throws Exception {
		Booking entity= bookingDao.getById((int) bookingid);
		String showDate=entity.getShowDate();
		LocalDateTime localDateTimeNow = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		LocalDateTime localshowDate = LocalDateTime.parse(showDate, formatter);
		long diffInHours = ChronoUnit.HOURS.between(localDateTimeNow, localshowDate);
		if(diffInHours<=0)
		{
		return "Time Over For Booking";	
		}
		else if(diffInHours<48)
		{
			return "Booking cannot be cancelled within 48 hours";
		}
		else
		{
			bookingDao.delete(entity);
			return "Booking Successfully Cancelled";
		}
	}
	@Override
	public int getEarning() {
		int totalEarning=0;
		List<BookingDetail> bookingDetail= bookingDetailDao.findAll();
		for(BookingDetail b: bookingDetail)
		{
			totalEarning+=b.getTotalCost();
		}
		return totalEarning;
	}

}
