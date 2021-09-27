package com.Multiplex.Model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "booking_detail")
public class BookingDetail{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private int book_id;
	@Column(name = "No_of_Seats")
	private float noOfSeats;
	@ManyToOne
	@JoinColumn(name="BOOKING_ID")
	private Booking booking;
	@ManyToOne
	@JoinColumn(name="SEAT_TYPE_ID")
	private SeatType seat;
	@Column(name="TOTAL_COST")
	private int totalCost;
	public SeatType getSeat() {
		return seat;
	}
	public void setSeat(SeatType seat) {
		this.seat = seat;
	}
	public BookingDetail() {
		super();
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public float getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(float noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	public int getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}
	
}
