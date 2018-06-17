package com.rogelioorts.training.spring.ddd.value.objects;

import java.util.List;

import com.rogelioorts.training.spring.ddd.entities.Movie;

public interface Filter {

	List<Movie> apply(List<Movie> movies);
	
}
