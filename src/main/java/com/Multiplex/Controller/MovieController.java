package com.Multiplex.Controller;

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

import com.Multiplex.Model.Movie;
import com.Multiplex.Model.Shows;
import com.Multiplex.Services.MovieService;

@RestController
@RequestMapping("/api/")
public class MovieController {
	@Autowired
	private MovieService movieService;

	@GetMapping("/users/movies")
	public List<Movie> getMovies()
	{
			return this.movieService.getMovies();
	}
	
	@GetMapping("/users/movies/{movieId}")
	public Optional<Movie> getMovie(@PathVariable String movieId)
	{
		return this.movieService.getMovie(Long.parseLong(movieId));
	}
	@GetMapping("/users/movies/name/{movieName}")
	public Optional<Shows> getMovieByShow(@PathVariable String movieName)
	{
		return this.movieService.getMovieByShow(movieName);
	}
	@PostMapping(path="/admin/movies",consumes="application/json")
	public String addMovie(@RequestBody Movie movie)
	{
		return this.movieService.addMovie(movie);
	}
	@PutMapping(path="/admin/movies",consumes="application/json")
	public String updateMovie(@RequestBody Movie movie)
	{
		return this.movieService.updateMovie(movie);
	}
	@DeleteMapping(path="/admin/movies/{movieId}")
	public ResponseEntity<HttpStatus> deleteMovie(@PathVariable String movieId)
	{
		try {
			this.movieService.deleteMovie(Long.parseLong(movieId));
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

}
