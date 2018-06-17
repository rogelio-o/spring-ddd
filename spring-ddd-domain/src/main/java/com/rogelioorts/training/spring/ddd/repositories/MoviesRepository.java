package com.rogelioorts.training.spring.ddd.repositories;

import java.util.List;

import com.rogelioorts.training.spring.ddd.entities.Movie;

public interface MoviesRepository {

	List<Movie> findAll();
	
}
