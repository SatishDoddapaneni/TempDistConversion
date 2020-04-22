package com.conversions.temperaturedistance.TempDistConversions.service;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.conversions.temperaturedistance.TempDistConversions.controller.ConversionsController;
import com.conversions.temperaturedistance.TempDistConversions.pojo.ConversionsPojo;



@Service
public class ConversionServiceLogic 
{
	private static final Logger logger = LogManager.getLogger(ConversionsController.class);
	
	@Autowired
	public ConversionsPojo kelvincelsiuspojo;
	
	@ExceptionHandler({IOException.class, NumberFormatException.class})
	public double kelvinToCelsiusService(double value) 
	{
		
		logger.info("You are inside kelvin to celsius conversion Service method");	
		
		double celsius = value-273.0;
		
		kelvincelsiuspojo.setCelsius(celsius);
		
		logger.info("kelvin to celsius conversion is completed");
		
		return kelvincelsiuspojo.getCelsius();
	}
	
	@ExceptionHandler({IOException.class, NumberFormatException.class})
	public void celsiusTokelvinService(double value) 
	{
		logger.info("you are inside celsius to Kelvin conversion service method");
		
		double kelvin = value + 273.15F;
		
		logger.info("celsius to Kelvin conversion completed");
		
		kelvincelsiuspojo.setKelvin(kelvin);
		
	}
	
	@ExceptionHandler({IOException.class, NumberFormatException.class})
	public double milesToKilometers(double value)
	{
		logger.info("you are inside Miles to Kilometers conversion service method");
		
		double kilometers = value * 1.6;
		
		logger.info("Miles to kilometers conversion completed");
		
		return kilometers;
		
	}
}