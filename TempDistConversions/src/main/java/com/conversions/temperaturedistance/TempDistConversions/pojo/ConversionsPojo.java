package com.conversions.temperaturedistance.TempDistConversions.pojo;

import org.springframework.stereotype.Component;

@Component
public class ConversionsPojo {
	
	private double kelvin;
	private double celsius;
	private double miles;
	private double kilometer;
	
	public double getKelvin() {
		return kelvin;
	}
	
	public void setKelvin(double kelvin) {
		this.kelvin = kelvin;
	}
	
	public double getCelsius() {
		return celsius;
	}
	
	public void setCelsius(double celsius) {
		this.celsius = celsius;
	}

	public double getMiles() {
		return miles;
	}

	public void setMiles(double miles) {
		this.miles = miles;
	}

	public double getKilometer() {
		return kilometer;
	}

	public void setKilometer(double kilometer) {
		this.kilometer = kilometer;
	}
}