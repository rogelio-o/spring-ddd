package com.rogelioorts.training.spring.ddd.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class FeignMovie {

	@EqualsAndHashCode.Include
	private long id;
	
	private String tit;
	
	private String poster;
	
	private String desc;
	
	private String url;
	
	private double punc;

	private String level;
	
}
