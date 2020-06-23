package com.springmicroservice.moviecatalogservice.resources;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.springmicroservice.moviecatalogservice.models.CatalogItem;
import com.springmicroservice.moviecatalogservice.models.Movie;
import com.springmicroservice.moviecatalogservice.models.Rating;
import com.springmicroservice.moviecatalogservice.services.MovieListService;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	//@Autowired
	//private WebClient.Builder webClientBuilder;
	
	@Autowired
	private MovieListService movieListService;

	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
		
		List<String> movieList = movieListService.getMovieList(userId);
		
		return movieList.stream().map(movieId -> {
			Movie movie = restTemplate.getForObject("http://localhost:8083/movies/" + movieId, Movie.class);
			Rating rating = restTemplate.getForObject("http://localhost:8084/ratingsdata/" + movieId, Rating.class);
			
			// another way to make api call using web client(Reactive programming in java).
			/*Movie movie = webClientBuilder.build()
					.get()
					.uri("http://localhost:8083/movies/" + rating.getMovieId())
					.retrieve()
					.bodyToMono(Movie.class)
					.block();*/
			
			return new CatalogItem(movie.getMovieName(), movie.getInfo(), rating.getRating());
			})
			.collect(Collectors.toList());

	}
}
