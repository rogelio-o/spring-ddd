package com.rogelioorts.training.spring.ddd.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rogelioorts.training.spring.ddd.entities.Movie;
import com.rogelioorts.training.spring.ddd.entities.MovieApi;
import com.rogelioorts.training.spring.ddd.mappers.FiltersApiMapper;
import com.rogelioorts.training.spring.ddd.mappers.MoviesApiMapper;
import com.rogelioorts.training.spring.ddd.services.MoviesService;

@RestController
@RequestMapping("/movies")
public class MoviesController {
	
	@Autowired
	private MoviesService moviesService;
	
	@Autowired
	private FiltersApiMapper filtersMapper;
	
	@Autowired
	private MoviesApiMapper moviesMapper; 

	@RequestMapping(method = RequestMethod.GET)
	public List<MovieApi> findAll(@RequestParam(required = false) List<String> filters, @RequestParam(required = false) String level) {
		List<Movie> movies = moviesService.findAll(filtersMapper.map(filters, level));
		
		return movies.stream().map(moviesMapper::map).collect(Collectors.toList());
	}
	
}
