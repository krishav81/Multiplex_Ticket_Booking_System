package com.Multiplex.Services;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.Multiplex.Model.Shows;

public interface ShowService {
	public Optional<Shows> getShowByID(long showId);
	public List<Shows> getShowByDate(String date);
	public List<Shows> getShowByHallName(String hallName);
	public List<Shows> getShowByMovieId(int movieId);
	public List<Shows> getShowByMovieName(String movieName);
	public String addShow(Shows show);
	public String updateShow(Shows show);
	public void deleteShow(long showid);
}