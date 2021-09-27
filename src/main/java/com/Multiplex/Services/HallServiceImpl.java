package com.Multiplex.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Multiplex.Dao.HallCapacityDao;
import com.Multiplex.Dao.HallDao;
import com.Multiplex.Dao.SeatTypeDao;
import com.Multiplex.Model.Hall;
import com.Multiplex.Model.HallCapacity;
import com.Multiplex.Model.SeatType;
@Service
public class HallServiceImpl implements HallService {
	@Autowired
	private HallDao hallDao;
	@Autowired
	private SeatTypeDao seatTypeDao;
	@Autowired
	private HallCapacityDao hallCapacityDao;
	@Override
	public List<Hall> getHalls() {
		return hallDao.findAll();
	}
	@Override
	public Optional<Hall> getHall(long hallId) {
		return hallDao.findById((int) hallId);
	}
	
	@Override
	public String addHall(Hall hall) {
		hallDao.save(hall);
		return "Hall Added Successfully";
	}

	@Override
	public void deleteHall(long hallId) {
		Hall entity= hallDao.getById((int) hallId);
		hallDao.delete(entity);
	}

	@Override
	public String addSeatType(SeatType seat) {
		seatTypeDao.save(seat);
		return "Seat Type added Successfully";
	}

	@Override
	public String addHallCapacity(HallCapacity capacity) {
		hallCapacityDao.saveAndFlush(capacity);
		return "Screen has been Added Successfully";
	}
	@Override
	public List<SeatType> getSeats() {
		return seatTypeDao.findAll();
	}
	@Override
	public void deleteSeats(long seatId) {
		SeatType seatType=seatTypeDao.getById((int)seatId);
		seatTypeDao.delete(seatType);
	}
	@Override
	public void deleteHallCapacity(long id) {
		HallCapacity hall=hallCapacityDao.getById((int) id);
		hallCapacityDao.delete(hall);
	}

}