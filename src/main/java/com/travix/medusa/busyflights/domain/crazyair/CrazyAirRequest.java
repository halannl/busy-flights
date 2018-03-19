package com.travix.medusa.busyflights.domain.crazyair;

public class CrazyAirRequest {

    private String origin; // 3 letter IATA code(eg. LHR, AMS)
    private String destination; // 3 letter IATA code(eg. LHR, AMS)
    private String departureDate; // ISO_LOCAL_DATE format
    private String returnDate; // ISO_LOCAL_DATE format
    private int passengerCount; // Number of passengers

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

    public int getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(final int passengerCount) {
        this.passengerCount = passengerCount;
    }
}
