package com.rogelioorts.training.spring.ddd.value.objects.impl;

import com.rogelioorts.training.spring.ddd.value.objects.CensoringLevel;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Getter
@Setter
public class FiltersData {

	private CensoringLevel censoringLevel;
	
}
