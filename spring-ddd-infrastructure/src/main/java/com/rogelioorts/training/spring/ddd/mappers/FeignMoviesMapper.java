package com.rogelioorts.training.spring.ddd.mappers;

import org.springframework.stereotype.Component;

import com.rogelioorts.training.spring.ddd.entities.FeignMovie;
import com.rogelioorts.training.spring.ddd.entities.Movie;
import com.rogelioorts.training.spring.ddd.value.objects.CensoringLevel;

@Component
public class FeignMoviesMapper {

	public Movie map(FeignMovie in) {
		Movie out = new Movie();
		out.setMovieId(String.valueOf(in.getId()));
		out.setTitle(in.getTit());
		out.setImage(in.getPoster());
		out.setDescription(in.getDesc());
		out.setStreamUrl(in.getUrl());
		out.setPunctuation(in.getPunc());
		out.setCensoringLevel(mapCensoringLevel(in.getLevel()));
		
		return out;
	}
	
	private CensoringLevel mapCensoringLevel(String rawLevel) {
		if(rawLevel == null) {
			return null;
		}
		
		switch(rawLevel) {
			case "censored":
				return CensoringLevel.CENSORED;
			case "uncensored":
				return CensoringLevel.UNCENSORED;
			default:
				return null;
		}
	}
	
}
