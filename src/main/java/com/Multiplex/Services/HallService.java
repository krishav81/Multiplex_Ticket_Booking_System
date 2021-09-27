package com.Multiplex.Services;
import java.util.List;
import java.util.Optional;

import com.Multiplex.Model.Hall;
import com.Multiplex.Model.HallCapacity;
import com.Multiplex.Model.SeatType;

public interface HallService {
	public List<Hall> getHalls();
	public Optional<Hall> getHall(long hallId);
	public String addHall(Hall hall);
	public void deleteHall(long hallId);
	public void deleteSeats(long seatId);
	public String addSeatType(SeatType seat);
	public String addHallCapacity(HallCapacity capacity);
	public List<SeatType> getSeats();
	public void deleteHallCapacity(long id);
}

