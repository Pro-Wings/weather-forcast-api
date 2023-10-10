package com.prowings;

import org.dozer.Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.prowings.model.Weather;
import com.prowings.model.dto.Climate;

@SpringBootTest
public class DozerTests {

    @Autowired
    Mapper mapper;

    @Test
    void myTest() {

    	Weather weather = new Weather();
    	weather.setCountryCode(91);
    	weather.setCity("Pune");
    	weather.setCountry("India");
    	weather.setDate(1696659549);
    	
    	Climate climate = mapper.map(weather, Climate.class);
    	
    	System.out.println(climate);
    }
}