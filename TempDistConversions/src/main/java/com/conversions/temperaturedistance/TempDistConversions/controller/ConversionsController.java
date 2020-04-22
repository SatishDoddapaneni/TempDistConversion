package com.conversions.temperaturedistance.TempDistConversions.controller;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.conversions.temperaturedistance.TempDistConversions.pojo.ConversionsPojo;
import com.conversions.temperaturedistance.TempDistConversions.service.ConversionServiceLogic;


@RestController
@RequestMapping("/conversions")
public class ConversionsController 
{
	private static final Logger logger = LogManager.getLogger(ConversionsController.class);
	
	@Autowired(required = true)
	public ConversionsPojo kelvincelsiuspojo;
	
	@Autowired(required = true)
	public ConversionServiceLogic temperatureconversionservice;

	
	@ExceptionHandler({IOException.class, NumberFormatException.class})
	@RequestMapping(value="/kelvintocelsius/{value}", method=RequestMethod.POST)
	public String kelvinToCelsiusController(@PathVariable("value") double value) 
	{
		long startTime = System.nanoTime();
		
		logger.info("Kelvin to celsius conversion application started");
		
		double kelvin = value;
		
		temperatureconversionservice.kelvinToCelsiusService(kelvin);
		
		long stopTime = System.nanoTime();
		
		logger.info("Kelvin to celsius conversion application started");
		System.out.println(stopTime - startTime);
		
		return value+"k" +" to celsius "+ kelvincelsiuspojo.getCelsius()+"°C";
		
	}
	
	
	@ExceptionHandler({IOException.class, NumberFormatException.class})
	@RequestMapping(value="/celsiustokelvin/{value}")
	public String celsiusTokelvin(@PathVariable("value") double value) 
	{
		logger.info("celsius to Kelvin conversion application started");
		
		temperatureconversionservice.celsiusTokelvinService(value);
		
		return value+"°C" +" to kelvin "+kelvincelsiuspojo.getKelvin()+"k";
		
	}
	
	@ExceptionHandler({IOException.class, NumberFormatException.class})
	@RequestMapping(value="/milestokilometers/{value}")
	public String milesToKilometers(@PathVariable("value") double value) 
	{
		logger.info("Miles to kilometers convrsion started");
		
		double kilometers = temperatureconversionservice.milesToKilometers(value);
		
		return value+"Mi" +" to Kilometer "+kilometers+"KM";
		
	}
	
	@ExceptionHandler({IOException.class, NumberFormatException.class})
	@RequestMapping(value="/kilometerstomiles/{value}")
	public String kilometersToMiles(@PathVariable("value") double value) 
	{
		logger.info("Kilometers To Miles conversion started");
		
		double kilometers = value;
		
		logger.info("you are inside Kilometers To Miles conversion method");
		
		double miles = kilometers / 1.6;
		
		logger.info("Kilometers To Miles conversion completed");
		
		kelvincelsiuspojo.setMiles(miles);
		
		return value+"KM" +" to Miles "+kelvincelsiuspojo.getMiles()+"Mi";
		
	}
}