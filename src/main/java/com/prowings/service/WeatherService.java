package com.prowings.service;

import org.springframework.http.ResponseEntity;

import com.prowings.model.Weather;

import reactor.core.publisher.Mono;

public interface WeatherService {
	

	public Mono<Weather> createWeather(Weather weather); 

	public Weather getWeatherByCity(String city); 

}
