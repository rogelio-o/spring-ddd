package com.rogelioorts.training.spring.ddd.repositories.value.objects.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.rogelioorts.training.spring.ddd.repositories.entities.Movie;
import com.rogelioorts.training.spring.ddd.repositories.value.objects.CensoringLevel;
import com.rogelioorts.training.spring.ddd.repositories.value.objects.Filter;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@AllArgsConstructor
public class CensoringFilter implements Filter {
	
	private CensoringLevel level;

	@Override
	public List<Movie> apply(List<Movie> movies) {
		return movies.stream().filter(this::checkMovieFilter).collect(Collectors.toList());
	}
	
	private boolean checkMovieFilter(Movie movie) {
		return level == null || level.equals(movie.getCensoringLevel());
	}

}
