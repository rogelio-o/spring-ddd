package com.rogelioorts.training.spring.ddd.repositories.factories;

import com.rogelioorts.training.spring.ddd.repositories.value.objects.CensoringLevel;
import com.rogelioorts.training.spring.ddd.repositories.value.objects.Filter;
import com.rogelioorts.training.spring.ddd.repositories.value.objects.impl.CensoringFilter;

public class FiltersFactory {

	public static Filter censoringFilter(CensoringLevel level) {
		return new CensoringFilter(level);
	}
	
}
