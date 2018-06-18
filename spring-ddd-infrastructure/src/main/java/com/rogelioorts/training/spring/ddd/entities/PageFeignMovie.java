package com.rogelioorts.training.spring.ddd.entities;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageFeignMovie {

	private List<FeignMovie> movies;
	
}
