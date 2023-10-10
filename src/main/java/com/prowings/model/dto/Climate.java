package com.prowings.model.dto;

import org.dozer.Mapping;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Climate {
	//mandatory
	private String city;
	//mandatory
	private String country;
	//mandatory
	private String countryCode;
	//mandatory
	private String date;
	//mandatory
	@Mapping("temperatureInCelcius")
	private double temperatureInFht;
	//mandatory
	private String weather;
	//optional
	private String weatherDesc;
	//optional
	private double tempFeelsLike;
	private double tempMin;
	private double tempMax;
	//mandatory
	private double pressure;
	//mandatory
	private double humidity;

}
