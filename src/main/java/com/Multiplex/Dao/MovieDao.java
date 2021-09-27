package com.Multiplex.Dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Multiplex.Model.Movie;
@Repository
public interface MovieDao extends JpaRepository<Movie,Integer> {

	public List<Movie> findByMovieName(String movieName);


}