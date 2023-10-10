package com.prowings.service;

import java.util.Arrays;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.prowings.model.Weather;
import com.prowings.model.dto.Climate;

import reactor.core.publisher.Mono;

@Service
public class WeatherServiceImpl implements WeatherService {

	@Autowired
	private final WebClient webClient;

	@Autowired
	private DozerBeanMapper mapper;
	
	public WeatherServiceImpl(WebClient webClient) {
		super();
		this.webClient = webClient;
	}

	@Override
	public Mono<Weather> createWeather(Weather weather) {
		
		//step 1 : convert incoming request into climate api specific
		//step 2 : call the climate api - using webclient
			// uri + requestbody + headers
		//step 3 : process the response 
		//step 4 : return the response
		
		Mono<Weather> weatherMono = webClient.post()
		  .uri("/climates")
	      .body(Mono.just(convertToClimate(weather)), Weather.class)
	      .retrieve()
	      .bodyToMono(Weather.class);

	    return weatherMono;
		
		
	}

	private Climate convertToClimate(Weather weather) {
		
	    List<String> mappingFiles = Arrays.asList(
	    	      "dozer_mapping2.xml");

		DozerBeanMapper mp = new DozerBeanMapper();
		mp.setMappingFiles(mappingFiles);
		Climate climate = mp.map(weather, Climate.class);
		return climate;
	}

	@Override
	public Weather getWeatherByCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}

}
