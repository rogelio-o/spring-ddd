package com.rogelioorts.training.spring.ddd.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.rogelioorts.training.spring.ddd.entities.Movie;
import com.rogelioorts.training.spring.ddd.entities.MovieApi;

@Mapper(componentModel = "spring")
public interface MoviesApiMapper {

	@Mapping(source = "movieId", target = "id")
    MovieApi map(Movie movie);
	
}
