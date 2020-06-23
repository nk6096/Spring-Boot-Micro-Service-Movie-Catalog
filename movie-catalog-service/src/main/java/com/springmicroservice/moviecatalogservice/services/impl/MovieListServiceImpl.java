package com.springmicroservice.moviecatalogservice.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springmicroservice.moviecatalogservice.services.MovieListService;

@Service
public class MovieListServiceImpl implements MovieListService {

	@Override
	public List<String> getMovieList(String userId) {
		
		List<String> movieList = new ArrayList<String>();
		movieList.add("MV456665");
		movieList.add("MV856752");
		movieList.add("MV256331");
		movieList.add("MV356643");
		movieList.add("MV754465");
		
		return movieList;
	}

}
