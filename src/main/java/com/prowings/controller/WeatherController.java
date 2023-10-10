package com.prowings.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prowings.model.Weather;
import com.prowings.service.WeatherService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1")
public class WeatherController {
	
	@Autowired
	WeatherService weatherService;

	@GetMapping("/test")
	public String hello()
	{
		return "welcome to weather forcasting api!!";
	}
	
	@PostMapping("/weathers")
	public Mono<Weather> predictNewWeather(@RequestBody Weather weather)
	{
		return weatherService.createWeather(weather);
	}
}
