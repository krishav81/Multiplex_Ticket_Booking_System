package com.Multiplex.Controller;

import java.util.List;
import java.util.Optional;
import java.time.LocalDate;
import com.Multiplex.Model.Shows;
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

import com.Multiplex.Services.ShowService;

@RestController
@RequestMapping("/api/")
public class ShowController {
	@Autowired
	private ShowService showService;

	@PostMapping(path="/admin/show",consumes="application/json")
	public String addShow(@RequestBody Shows show)
	{
		return this.showService.addShow(show);
	}
	
	@PutMapping(path="/admin/show",consumes="application/json")
	public String updateShow(@RequestBody Shows show)
	{
		return this.showService.updateShow(show);
	}
	
	@GetMapping("/show/{showId}")
	public Optional<Shows> getShowByID(@PathVariable String showId)
	{
		return this.showService.getShowByID(Long.parseLong(showId));
	}
	
	@GetMapping("/users/show/date/{date}")
	public List<Shows> getShowByDate(@PathVariable String date)
	{
		return this.showService.getShowByDate(date);
	}
	
	@GetMapping("/users/show/hall/{hallName}")
	public List<Shows> getShowByHallName(@PathVariable String hallName)
	{
		return this.showService.getShowByHallName(hallName);
	}
	
	@GetMapping("/show/movie/{movieId}")
	public List<Shows> getShowByMovieId(@PathVariable Integer movieId)
	{
		return this.showService.getShowByMovieId(movieId);
	}
	@GetMapping("/users/show/movie/name/{movieName}")
	public List<Shows> getShowByMovieName(@PathVariable String movieName)
	{
		return this.showService.getShowByMovieName(movieName);
	}
	
	@DeleteMapping(path="/users/show/{showId}")
	public ResponseEntity<HttpStatus> deleteShow(@PathVariable String showId)
	{
		try {
			this.showService.deleteShow(Long.parseLong(showId));
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}