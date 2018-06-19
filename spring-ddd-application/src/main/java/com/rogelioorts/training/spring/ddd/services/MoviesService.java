package com.rogelioorts.training.spring.ddd.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rogelioorts.training.spring.ddd.entities.Movie;
import com.rogelioorts.training.spring.ddd.exceptions.BadRequestException;
import com.rogelioorts.training.spring.ddd.factories.FiltersFactory;
import com.rogelioorts.training.spring.ddd.repositories.MoviesRepository;
import com.rogelioorts.training.spring.ddd.value.objects.Filter;
import com.rogelioorts.training.spring.ddd.value.objects.impl.FiltersData;

@Service
public class MoviesService {
	
	@Autowired
	private MoviesRepository moviesRepository;

	public List<Movie> findAll(List<String> filtersIds, FiltersData filterData) throws BadRequestException {
		List<Movie> movies = moviesRepository.findAll();
		
		if(filtersIds != null) {
			for(Filter filter: getFilters(filtersIds, filterData)) {
				movies = filter.apply(movies);
			}
		}
		
		return movies;
	}
	
	private List<Filter> getFilters(List<String> filtersIds, FiltersData filterData) throws BadRequestException {
		List<Filter> result = new ArrayList<>();
		
		for(String filterId : filtersIds) {
			result.add(getFilter(filterId, filterData));
		}
		
		return result;
	}
	
	private Filter getFilter(String filterId, FiltersData filterData) throws BadRequestException {
		if(Filter.CENSORING.equals(filterId)) {
			if(filterData == null || filterData.getCensoringLevel() == null) {
				throw new BadRequestException("Censoring level cannot be empty if there is a \"censoring\" filter.");
			}
			
			return FiltersFactory.censoringFilter(filterData.getCensoringLevel());
		} else {
			throw new BadRequestException("Not valid filter \"" + filterId + "\"");
		}
	}
	
}
