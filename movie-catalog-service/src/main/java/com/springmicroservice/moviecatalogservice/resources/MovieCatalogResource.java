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

import com.springmicroservice.moviecatalogservice.models.CatalogItem;
import com.springmicroservice.moviecatalogservice.models.Movie;
import com.springmicroservice.moviecatalogservice.models.Rating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
		
		List<Rating> ratingsList = Arrays.asList(
				new Rating("1234", 4),
				new Rating("4356", 3)
				);
		
		return ratingsList.stream().map(rating -> {
			Movie movie = restTemplate.getForObject("http://localhost:8083/movies/" + rating.getMovieId(), Movie.class);
			return new CatalogItem(movie.getMovieName(), movie.getInfo(), rating.getRating());
			})
			.collect(Collectors.toList());

	}
}
