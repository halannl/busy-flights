package com.travix.medusa.busyflights.domain.busyflights;

public class BusyFlightsResponse implements Comparable<BusyFlightsResponse> {

	private String airline; // Name of Airline
	private String supplier; // Eg: CrazyAir or ToughJet
	private double fare; // Total price rounded to 2 decimals
	private String departureAirportCode; // 3 letter IATA code(eg. LHR, AMS)
	private String destinationAirportCode; // 3 letter IATA code(eg. LHR, AMS)
	private String departureDate; // ISO_DATE_TIME format
	private String arrivalDate; // ISO_DATE_TIME format

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public String getDepartureAirportCode() {
		return departureAirportCode;
	}

	public void setDepartureAirportCode(String departureAirportCode) {
		this.departureAirportCode = departureAirportCode;
	}

	public String getDestinationAirportCode() {
		return destinationAirportCode;
	}

	public void setDestinationAirportCode(String destinationAirportCode) {
		this.destinationAirportCode = destinationAirportCode;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	@Override
	public int compareTo(BusyFlightsResponse o) {
		return Double.compare(this.fare, o.getFare());
	}
}
