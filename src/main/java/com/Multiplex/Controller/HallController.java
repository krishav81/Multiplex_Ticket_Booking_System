package com.Multiplex.Controller;

import com.Multiplex.Model.Hall;
import com.Multiplex.Model.HallCapacity;
import com.Multiplex.Model.SeatType;

import java.util.List;
import java.util.Optional;

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

import com.Multiplex.Services.HallService;

@RestController
@RequestMapping("/api/")
public class HallController {
	@Autowired
	private HallService hallService;
	

	@GetMapping("/users/halls")
	public List<Hall> getHalls()
	{
			return this.hallService.getHalls();
	}
	@GetMapping("/admin/seat")
	public List<SeatType> getSeats()
	{
			return this.hallService.getSeats();
	}
	
	@GetMapping("/users/halls/{hallId}")
	public Optional<Hall> getHall(@PathVariable String hallId)
	{
		return this.hallService.getHall(Long.parseLong(hallId));
	}
	
	@PostMapping(path="/admin/halls",consumes="application/json")
	public String addHall(@RequestBody Hall hall)
	{
		return this.hallService.addHall(hall);
	}
	@PostMapping(path="/admin/halls/seat",consumes="application/json")
	public String addSeatType(@RequestBody SeatType seat)
	{
		return this.hallService.addSeatType(seat);
	}
	@PostMapping(path="/admin/halls/capacity",consumes="application/json")
	public String addHallCapacity(@RequestBody HallCapacity capacity)
	{
		return this.hallService.addHallCapacity(capacity);
	}
	@DeleteMapping(path="/admin/hall/{hallId}")
	public ResponseEntity<HttpStatus> deleteHall(@PathVariable String hallId)
	{
		try {
			this.hallService.deleteHall(Long.parseLong(hallId));
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping(path="/admin/seat/{seatId}")
	public ResponseEntity<HttpStatus> deleteSeats(@PathVariable String seatId)
	{
		try {
			this.hallService.deleteSeats(Long.parseLong(seatId));
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping(path="/admin/halls/capacity/{id}")
	public ResponseEntity<HttpStatus> deleteHallCapacity(@PathVariable String id)
	{
		try {
			this.hallService.deleteHallCapacity(Long.parseLong(id));
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}