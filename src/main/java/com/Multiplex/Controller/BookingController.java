package com.Multiplex.Controller;
import com.Multiplex.Model.Booking;
import com.Multiplex.Model.Ticket;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Multiplex.Services.BookingService;

@RestController
@RequestMapping("/api/")
public class BookingController {
	@Autowired
	private BookingService bookingService;
	@GetMapping("/users/booking/{bookingId}")
	public Booking getBooking(@PathVariable String bookingId)
	{
		return this.bookingService.getBooking(Long.parseLong(bookingId));
	}
	@GetMapping("/admin/earning")
	public int getEarning()
	{
		return this.bookingService.getEarning();
	}
	@PostMapping(path="/users/booking",consumes="application/json")
	public String addBooking(@RequestBody Ticket ticket)
	{
		return this.bookingService.addBooking(ticket);
	}
	@DeleteMapping(path="/users/booking/{bookingId}")
	public String deleteBooking(@PathVariable String bookingId) throws NumberFormatException, Exception
	{
			return this.bookingService.deleteBooking(Long.parseLong(bookingId));
	}
}