package com.springmicroservice.moviecatalogservice.services;

import java.util.List;

public interface MovieListService {
	
	public List<String> getMovieList(String userId);
}
