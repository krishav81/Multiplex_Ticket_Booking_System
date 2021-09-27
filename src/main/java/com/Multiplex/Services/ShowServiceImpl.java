package com.Multiplex.Services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Multiplex.Dao.ShowsDao;
import com.Multiplex.Model.Shows;
@Service
public class ShowServiceImpl implements ShowService {
	@Autowired
	private ShowsDao showDao;
	@Override
	public Optional<Shows> getShowByID(long showId) {
		Optional<Shows> show=showDao.findById((int) showId);
		return show;
	}
	@Override
	public List<Shows> getShowByDate(String date) {
		List<Shows> show=showDao.findByFromDateLike(date);
		return show;
	}
	@Override
	public List<Shows> getShowByHallName(String hallName) {
		List<Shows> show=showDao.findByHallHallDesc(hallName);
		return show;
	}

	@Override
	public List<Shows> getShowByMovieId(int movieId) {
		List<Shows> show=showDao.findByMovieMovieId(movieId);
		return show;
	}

	@Override
	public List<Shows> getShowByMovieName(String movieName) {
		List<Shows> show=showDao.findByMovieMovieName(movieName);
		return show;
	}

	@Override
	public String addShow(Shows show) {
		showDao.save(show);
		return "Show has been Added Successfully";
	}

	@Override
	public String updateShow(Shows show) {
		showDao.save(show);
		return "Show has been updated Successfully";
	}

	@Override
	public void deleteShow(long showid) {
		Shows show= showDao.getById((int) showid);
		showDao.delete(show);
	}

}
