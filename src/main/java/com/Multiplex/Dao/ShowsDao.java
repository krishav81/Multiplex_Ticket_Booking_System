package com.Multiplex.Dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Multiplex.Model.Movie;
import com.Multiplex.Model.Shows;
@Repository
public interface ShowsDao extends JpaRepository<Shows,Integer> {

	public List<Shows> findByMovieMovieId(int movieId);
	public List<Shows> findByFromDateLike(String date);
	public List<Shows> findByMovieMovieName(String movieName);
	public List<Shows> findByHallHallDesc(String hallName);
}