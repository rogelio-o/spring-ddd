package com.rogelioorts.training.spring.ddd.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeignMovie {

	private long id;
	
	private String tit;
	
	private String poster;
	
	private String desc;
	
	private String url;
	
	private double punc;

	private String level;
	
}
