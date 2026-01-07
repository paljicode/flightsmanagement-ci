package com.testeddatasystems.flightwithpassengers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.testeddatasystems.flights.Flight;
import com.testeddatasystems.passengers.Passenger;

public class FlightWithPassengersTest {

	private Flight flight = new Flight("AA123", 1);

	@Test
	public void testNumberOfSeats() {
		Passenger passenger1 = new Passenger("124-56-7890", "Michael Johnson", "US");
		flight.addPassenger(passenger1);
		assertEquals(1, flight.getNumberOfPassengers());
		Passenger passenger2 = new Passenger("127-23-7991", "John Smith", "GB");
		assertThrows(RuntimeException.class, () -> flight.addPassenger(passenger2));
	}

}
