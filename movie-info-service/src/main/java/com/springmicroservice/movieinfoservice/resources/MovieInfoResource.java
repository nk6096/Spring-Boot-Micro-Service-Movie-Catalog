package com.springmicroservice.movieinfoservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.springmicroservice.movieinfoservice.models.Movie;
import com.springmicroservice.movieinfoservice.models.MovieSummary;

@RestController
@RequestMapping("/movies")
public class MovieInfoResource {
	
	@Value("${api.key}")
	private String apiKey;
	
	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
		try {
			MovieSummary movieSummary = restTemplate.getForObject(
					"https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKey, MovieSummary.class);
			return new Movie(movieSummary.getTitle() , movieSummary.getOverview());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new Movie(movieId , "Test Data");
	}
}
