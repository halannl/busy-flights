package com.travix.medusa.busyflights.domain.crazyair;

import java.time.format.DateTimeFormatter;

public class CrazyAirResponse {

    private String airline; // Name of the airline
    private double price; // Total price
    private String cabinclass; // E for Economy and B for Business
    private String departureAirportCode; // Eg: LHR
    private String destinationAirportCode; // Eg: LHR
    private String departureDate; // ISO_LOCAL_DATE_TIME format
    private String arrivalDate; // ISO_LOCAL_DATE_TIME format

    public String getAirline() {
        return airline;
    }

    public void setAirline(final String airline) {
        this.airline = airline;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(final double price) {
        this.price = price;
    }

    public String getCabinclass() {
        return cabinclass;
    }

    public void setCabinclass(final String cabinclass) {
        this.cabinclass = cabinclass;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public void setDepartureAirportCode(final String departureAirportCode) {
        this.departureAirportCode = departureAirportCode;
    }

    public String getDestinationAirportCode() {
        return destinationAirportCode;
    }

    public void setDestinationAirportCode(final String destinationAirportCode) {
        this.destinationAirportCode = destinationAirportCode;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(final String departureDate) {
        this.departureDate = departureDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(final String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
    
    /**
     * Method that returns a mock containing an array of response objects
     * @param request
     * @param numOfItems
     * @return array of response objects
     */
    public static CrazyAirResponse[] mockResults(CrazyAirRequest request, int numOfItems) {
    	CrazyAirResponse[] toReturn = new CrazyAirResponse[numOfItems];
    	
		for(int i = 0 ; i < numOfItems ; i++) {
			CrazyAirResponse car = new CrazyAirResponse();
			car.setAirline("company " + i);
			car.setArrivalDate(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(DateTimeFormatter.ISO_LOCAL_DATE.parse(request.getReturnDate())));
			car.setDepartureDate(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(DateTimeFormatter.ISO_LOCAL_DATE.parse(request.getDepartureDate())));
			car.setCabinclass(i % 2 != 0? "E" : "B");
			car.setDepartureAirportCode(request.getOrigin());
			car.setDestinationAirportCode(request.getDestination());
			car.setPrice(10 * (i+1));
			toReturn[i] = car;
		}
    	
    	return toReturn;
    }
}
