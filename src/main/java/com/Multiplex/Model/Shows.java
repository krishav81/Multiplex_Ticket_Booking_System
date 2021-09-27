package com.Multiplex.Model;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Shows {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="Show_ID")
private int showId;
@Column(name="Slot_No")
private int slotNo;
@Column(name="Start_Date")
private String fromDate;
@Column(name="End_Date")
private String ToDate;
@OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
private List<Booking> booking;
@ManyToOne
@JoinColumn(name="MOVIE_ID")
private Movie movie;
@ManyToOne
@JoinColumn(name="HALL_ID")
private Hall hall;

public Shows() {
	super();
}

public int getShowId() {
	return showId;
}

public void setShowId(int showId) {
	this.showId = showId;
}

public int getSlotNo() {
	return slotNo;
}

public void setSlotNo(int slotNo) {
	this.slotNo = slotNo;
}

public String getFromDate() {
	return fromDate;
}

public void setFromDate(String fromDate) {
	this.fromDate = fromDate;
}

public String getToDate() {
	return ToDate;
}

public void setToDate(String toDate) {
	ToDate = toDate;
}

public List<Booking> getBooking() {
	return booking;
}

public void setBooking(List<Booking> booking) {
	this.booking = booking;
}
public Movie getMovie() {
	return movie;
}

public void setMovie(Movie movie) {
	this.movie = movie;
}
public Hall getHall() {
	return hall;
}

public void setHall(Hall hall) {
	this.hall = hall;
}

@Override
public String toString() {
	return "Shows [showId=" + showId + ", slotNo=" + slotNo + ", fromDate=" + fromDate + ", ToDate=" + ToDate
			+ ", booking=" + booking + ", movie=" + movie + ", hall=" + hall + "]";
}

}
