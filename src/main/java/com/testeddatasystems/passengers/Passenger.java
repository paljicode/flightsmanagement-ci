package com.testeddatasystems.passengers;

import java.util.Arrays;
import java.util.Locale;

public class Passenger {

	private String identifier;
	private String name;
	private String countryCode;

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

	@Override
	public String toString() {
		return "Passenger " + getName() + " with identifier: " + getIdentifier() + " from " + getCountryCode();
	}

}
