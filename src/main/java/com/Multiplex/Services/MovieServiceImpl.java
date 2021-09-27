package com.Multiplex.Services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Multiplex.Dao.MovieDao;
import com.Multiplex.Dao.ShowsDao;
import com.Multiplex.Model.Movie;
import com.Multiplex.Model.Shows;
@Service
public class MovieServiceImpl implements MovieService {
	@Autowired
	private MovieDao movieDao;
	@Autowired
	private ShowsDao showsDao;
	@Override
	public List<Movie> getMovies() {
		
		return movieDao.findAll();
	}

	@Override
	public Optional<Movie> getMovie(long movieId) {
	
		return movieDao.findById((int) movieId);
	}

	@Override
	public String addMovie(Movie movie) {
	
		movieDao.save(movie);
		return "Movie Added Successfully";
	}

	@Override
	public void deleteMovie(long movieId) {
		Movie entity= movieDao.getById((int) movieId);
		movieDao.delete(entity);
	}

	@Override
	public Optional<Shows> getMovieByShow(String movieName) {
		List<Movie> movie=movieDao.findByMovieName(movieName);
		Optional<Shows> shows=null;
		for(Movie m: movie)
		{
			int id=m.getMovieId();
			shows= showsDao.findById(id);
		}
		return shows;
	}

	@Override
	public String updateMovie(Movie movie) {
		movieDao.save(movie);
		return "Movie Updated Successfully" ;
	}

}
