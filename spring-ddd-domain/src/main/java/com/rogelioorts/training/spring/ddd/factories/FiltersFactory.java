package com.rogelioorts.training.spring.ddd.factories;

import com.rogelioorts.training.spring.ddd.value.objects.CensoringLevel;
import com.rogelioorts.training.spring.ddd.value.objects.Filter;
import com.rogelioorts.training.spring.ddd.value.objects.impl.CensoringFilter;

public class FiltersFactory {

	public static Filter censoringFilter(CensoringLevel level) {
		return new CensoringFilter(level);
	}
	
}
