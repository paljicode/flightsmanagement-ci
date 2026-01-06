package com.testeddatasystems.passengers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class PassengerTest {

	@Test
	public void testPassengerCreation() {
		Passenger passenger = new Passenger("123-45-6789", "John Smith", "US");
		assertNotNull(passenger);
	}

	@Test
	public void testInvalidCountryCode() {
		assertThrows(RuntimeException.class, () -> {
			Passenger passenger = new Passenger("900-45-6789", "John Smith", "GJ");
		});

	}

	@Test
	public void testPassengerToString() {
		Passenger passenger = new Passenger("123-45-6789", "John Smith", "US");
		assertEquals("Passenger John Smith with identifier: 123-45-6789 from US", passenger.toString());
	}

}
