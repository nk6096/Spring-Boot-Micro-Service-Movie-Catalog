package com.springmicroservice.moviecatalogservice.models;

public class Movie {

	private String movieName;
	private String info;

	public Movie() {
		
	}
	
	public Movie(String movieName, String info) {
		this.movieName = movieName;
		this.info = info;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
}
