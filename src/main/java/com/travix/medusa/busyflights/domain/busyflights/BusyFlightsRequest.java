package com.travix.medusa.busyflights.domain.busyflights;

public class BusyFlightsRequest {

	private String origin; // 3 letter IATA code(eg. LHR, AMS)
	private String destination; // 3 letter IATA code(eg. LHR, AMS)
	private String departureDate; // ISO_LOCAL_DATE format
	private String returnDate; // ISO_LOCAL_DATE format
	private int numberOfPassengers; // Maximum 4 passengers

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(final String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(final String destination) {
		this.destination = destination;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(final String departureDate) {
		this.departureDate = departureDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(final String returnDate) {
		this.returnDate = returnDate;
	}

	public int getNumberOfPassengers() {
		return numberOfPassengers;
	}

	public void setNumberOfPassengers(final int numberOfPassengers) {
		this.numberOfPassengers = numberOfPassengers;
	}
}
