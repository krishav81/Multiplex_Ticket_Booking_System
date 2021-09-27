package com.Multiplex.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="movie")
public class Movie {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int movieId;
@Column(name="Movie_Name" ,nullable = false)
private String movieName;
@OneToMany(mappedBy = "movie",cascade = CascadeType.ALL)
@JsonIgnore
private List<Shows> show;
public Movie() {
	super();
}
public int getMovieId() {
	return movieId;
}
public void setMovieId(int movieId) {
	this.movieId = movieId;
}
public String getMovieName() {
	return movieName;
}
public void setMovieName(String movieName) {
	this.movieName = movieName;
}
public List<Shows> getShow() {
	return show;
}
public void setShow(List<Shows> show) {
	this.show = show;
}
}
