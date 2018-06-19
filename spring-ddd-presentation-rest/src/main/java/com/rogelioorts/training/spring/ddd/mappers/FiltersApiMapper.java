package com.rogelioorts.training.spring.ddd.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.rogelioorts.training.spring.ddd.entities.FiltersDataApi;
import com.rogelioorts.training.spring.ddd.value.objects.CensoringLevel;
import com.rogelioorts.training.spring.ddd.value.objects.impl.FiltersData;

@Mapper(componentModel = "spring")
public interface FiltersApiMapper {

	@Mapping(source = "level", target = "censoringLevel")
    FiltersData map(FiltersDataApi data);
	
	default CensoringLevel map(String value) {
        if (value == null) {
            return null;
        }

        switch(value) {
            case "censored":
                return CensoringLevel.CENSORED;
            case "uncensored":
                return CensoringLevel.UNCENSORED;
            default:
            	return null;
        }
    }
	
}
