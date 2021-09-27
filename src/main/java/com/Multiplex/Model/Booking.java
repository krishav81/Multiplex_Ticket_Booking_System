package com.Multiplex.Model;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
@Table(name ="BOOKING_REG")
public class Booking {
	@Id
	@Column(name="BOOKING_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int BookingId;
	@Column(name="BOOKED_DATE")
	private String BookedDate;
	@Column(name="SHOW_DATE")
	private String ShowDate;
	@ManyToOne()
	@JoinColumn(name="USER_ID")
	private Users username;
	@ManyToOne()
	@JoinColumn(name="SHOW_ID")
	private Shows show;
	@OneToMany(mappedBy = "booking",cascade = CascadeType.ALL)
	@JsonIgnore
	private List<BookingDetail> bookingDetail;
	
	public Booking() {
		super();
	}

	public int getBookingId() {
		return BookingId;
	}

	public void setBookingId(int bookingId) {
		BookingId = bookingId;
	}
	public String getBookedDate() {
		return BookedDate;
	}

	public void setBookedDate(String bookedDate) {
		BookedDate = bookedDate;
	}

	public String getShowDate() {
		return ShowDate;
	}

	public void setShowDate(String showDate) {
		ShowDate = showDate;
	}
	public Users getUsername() {
		return username;
	}
	
	public void setUsername(Users username) {
		this.username = username;
	}
	public Shows getShow() {
		return show;
	}

	public void setShow(Shows show) {
		this.show = show;
	}

	public List<BookingDetail> getBookingDetail() {
		return bookingDetail;
	}

	public void setBookingDetail(List<BookingDetail> bookingDetail) {
		this.bookingDetail = bookingDetail;
	}
}