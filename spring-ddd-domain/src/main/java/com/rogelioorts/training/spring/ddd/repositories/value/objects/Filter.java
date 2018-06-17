package com.rogelioorts.training.spring.ddd.repositories.value.objects;

import java.util.List;

import com.rogelioorts.training.spring.ddd.repositories.entities.Movie;

public interface Filter {

	List<Movie> apply(List<Movie> movies);
	
}
