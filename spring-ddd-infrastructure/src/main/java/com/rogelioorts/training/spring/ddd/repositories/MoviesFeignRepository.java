package com.rogelioorts.training.spring.ddd.repositories;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rogelioorts.training.spring.ddd.entities.PageFeignMovie;

@FeignClient("${movies-server.url}")
public interface MoviesFeignRepository {

	@RequestMapping(method = RequestMethod.GET, path = "/movies")
	PageFeignMovie getPage();
	
}
