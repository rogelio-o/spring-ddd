package com.rogelioorts.training.spring.ddd.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieApi {

	private String id;
	
	private String title;
	
	private String image;
	
	private String description;
	
	private double punctuation;

	private String censoringLevel;
	
}
