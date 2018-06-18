package com.rogelioorts.training.spring.ddd.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.rogelioorts.training.spring.ddd.factories.FiltersFactory;
import com.rogelioorts.training.spring.ddd.value.objects.CensoringLevel;
import com.rogelioorts.training.spring.ddd.value.objects.Filter;

@Component
public class FiltersApiMapper {

	public List<Filter> map(List<String> rawFilters, String censoringLevel) {
		List<Filter> filters = new ArrayList<>();
		
		if(rawFilters != null) {
			for(String filterId : rawFilters) {
				filters.add(map(filterId, censoringLevel));
			}
		}
		
		return filters;
	}
	
	private Filter map(String filterId, String censoringLevel) {
		if("censoring".equals(filterId)) {
			return FiltersFactory.censoringFilter(mapCensoringLevel(censoringLevel));
		} else {
			throw new IllegalArgumentException("Not valid filter ID \"" + filterId + "\"");
		}
	}
	
	private CensoringLevel mapCensoringLevel(String censoringLevel) {
		switch(censoringLevel) {
			case "CENSORED":
				return CensoringLevel.CENSORED;
			case "UNCENSORED":
				return CensoringLevel.UNCENSORED;
			default: 
				throw new IllegalArgumentException("Not valid censoring level \"" + censoringLevel + "\"");
		}
	}
	
}
