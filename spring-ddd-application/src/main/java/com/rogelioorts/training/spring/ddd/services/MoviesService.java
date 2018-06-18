package com.rogelioorts.training.spring.ddd.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rogelioorts.training.spring.ddd.entities.Movie;
import com.rogelioorts.training.spring.ddd.repositories.MoviesRepository;
import com.rogelioorts.training.spring.ddd.value.objects.Filter;

@Service
public class MoviesService {
	
	@Autowired
	private MoviesRepository moviesRepository;

	public List<Movie> findAll(List<Filter> filters) {
		List<Movie> movies = moviesRepository.findAll();
		
		for(Filter filter: filters) {
			movies = filter.apply(movies);
		}
		
		return movies;
	}
	
}
