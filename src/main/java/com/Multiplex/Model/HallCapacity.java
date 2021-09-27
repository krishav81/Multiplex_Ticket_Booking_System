package com.Multiplex.Model;

import javax.persistence.CascadeType;
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
@Table(name="Hall_Capacity")
public class HallCapacity {
	@Id
	@Column(name="Hall_Capacity_ID")
	private int hallCapId;
	@Column(name="Seat_Count",nullable=false)
	private int seatCount;
	@ManyToOne
	@JoinColumn(name="HALL_ID")
	private Hall hall;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="SEAT_TYPE")
	private SeatType seatType;
	public HallCapacity() {
		super();
	}
	public int getSeatCount() {
		return seatCount;
	}
	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}
	public Hall getHall() {
		return hall;
	}
	public void setHall(Hall hall) {
		this.hall = hall;
	}
	public int getHallCapId() {
		return hallCapId;
	}
	public void setHallCapId(int hallCapId) {
		this.hallCapId = hallCapId;
	}
	@Override
	public String toString() {
		return "HallCapacity [hallCapId=" + hallCapId + ", seatCount=" + seatCount + ", hall=" + hall + ", seatType="
				+ seatType + "]";
	}
	public SeatType getSeatType() {
		return seatType;
	}
	public void setSeatType(SeatType seatType) {
		this.seatType = seatType;
	}
	
}
