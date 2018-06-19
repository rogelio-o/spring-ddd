package com.rogelioorts.training.spring.ddd.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rogelioorts.training.spring.ddd.entities.FiltersDataApi;
import com.rogelioorts.training.spring.ddd.entities.Movie;
import com.rogelioorts.training.spring.ddd.entities.MovieApi;
import com.rogelioorts.training.spring.ddd.exceptions.BadRequestException;
import com.rogelioorts.training.spring.ddd.mappers.FiltersApiMapper;
import com.rogelioorts.training.spring.ddd.mappers.MoviesApiMapper;
import com.rogelioorts.training.spring.ddd.services.MoviesService;

@RestController
@RequestMapping("/movies")
public class MoviesController {
	
	@Autowired
	private MoviesService moviesService;
	
	@Autowired
	private MoviesApiMapper moviesMapper; 
	
	@Autowired
	private FiltersApiMapper filtersApiMapper;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<MovieApi> findAll(@RequestParam(required = false) List<String> filters, FiltersDataApi data) throws BadRequestException {
		List<Movie> movies = moviesService.findAll(filters, filtersApiMapper.map(data));
		
		return movies.stream().map(moviesMapper::map).collect(Collectors.toList());
	}
	
}
