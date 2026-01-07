package com.testeddatasystems.passengers;

import java.util.Arrays;
import java.util.Locale;

import com.testeddatasystems.flights.Flight;

public class Passenger {

	private String identifier;
	private String name;
	private String countryCode;
	private Flight flight;//John adds a Flight field to the Passenger class.
	
	//He creates a getter  and a setter d for the newly added field.

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Passenger(String identifier, String name, String countryCode) {
		if (!Arrays.asList(Locale.getISOCountries()).contains(countryCode)) {
			throw new RuntimeException("Invalid country code");

		}

		this.identifier = identifier;
		this.name = name;
		this.countryCode = countryCode;

	}

	public String getIdentifier() {
		return identifier;
	}

	public String getName() {
		return name;
	}

	public String getCountryCode() {
		return countryCode;
	}
	
	//John adds joinFlight method
	public void joinFlight(Flight flight) {
//checks whether a previous flight exists for the passenger and, if so, removes the passenger from it		
		Flight previousFlight = this.flight;
		if(null != previousFlight ) {
			//If the removal is not successful,the method throws an exception
			if(!previousFlight.removePassenger(this)) {
				throw new RuntimeException("cannot remove passenger");
				
			}
		}
		
		setFlight(flight);//Then it sets the flight for the passenger
		 if(null != flight) {//If the new flight is not null
			 if(!flight.addPassenger(this)) { //the method adds the passenger to it.
				 //If the passenger cannot be added, the method throws an exception
				 throw new RuntimeException("cannot add passenger");
			 }
			 
		 }
		 
		
	}

	@Override
	public String toString() {
		return "Passenger " + getName() + " with identifier: " + getIdentifier() + " from " + getCountryCode();
	}

}
