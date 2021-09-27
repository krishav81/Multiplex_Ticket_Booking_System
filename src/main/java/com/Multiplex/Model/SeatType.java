package com.Multiplex.Model;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.Multiplex.enums.SeatTypes;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "seat_type")
public class SeatType{
	@Id
	@Column(name = "Seat_Type_Id")
	private int seatTypeId;
	@Enumerated(EnumType.STRING)
	@Column(name = "seat_type", nullable = false)
	private SeatTypes seatType;
	@Column(name = "Seat_Fare")
	private float seatFare;
	@OneToMany(mappedBy = "seat",cascade = CascadeType.ALL)
	@JsonIgnore
	private List<BookingDetail> bookingDetail;
	@OneToMany(mappedBy = "seatType",cascade = CascadeType.ALL)
	@JsonIgnore
	private List<HallCapacity> hallCapacity;
	public SeatTypes getSeatType() {
		return seatType;
	}
	public void setSeatType(SeatTypes seatType) {
		this.seatType = seatType;
	}
	public SeatType() {
		
	}
	public int getSeatTypeId() {
		return seatTypeId;
	}
	public void setSeatTypeId(int seatTypeId) {
		this.seatTypeId = seatTypeId;
	}
	public float getSeatFare() {
		return seatFare;
	}
	public void setSeatFare(float seatFare) {
		this.seatFare = seatFare;
	}
	public List<BookingDetail> getBookingDetail() {
		return bookingDetail;
	}
	public void setBookingDetail(List<BookingDetail> bookingDetail) {
		this.bookingDetail = bookingDetail;
	}
	public List<HallCapacity> getHallCapacity() {
		return hallCapacity;
	}
	public void setHallCapacity(List<HallCapacity> hallCapacity) {
		this.hallCapacity = hallCapacity;
	}
	@Override
	public String toString() {
		return "SeatType [seatTypeId=" + seatTypeId + ", seatType=" + seatType + ", seatFare=" + seatFare
				+ ", bookingDetail=" + bookingDetail + ", hallCapacity=" + hallCapacity + "]";
	}
}