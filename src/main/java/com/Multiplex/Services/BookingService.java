package com.Multiplex.Services;
import java.util.List;

import com.Multiplex.Model.Booking;
import com.Multiplex.Model.Ticket;

public interface BookingService {
	public Booking getBooking(long bookingId);
	public String addBooking(Ticket ticket);
	public String deleteBooking(long bookingid) throws Exception;
	public int getEarning();
}