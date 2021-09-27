package com.Multiplex.Services;

import java.util.List;
import java.util.Optional;

import com.Multiplex.Model.Movie;
import com.Multiplex.Model.Shows;

public interface MovieService {
	public List<Movie> getMovies();
	public Optional<Movie> getMovie(long movieId);
	public String addMovie(Movie movie);
	public void deleteMovie(long movieid);
	public Optional<Shows> getMovieByShow(String movieName);
	public String updateMovie(Movie movie);
}
