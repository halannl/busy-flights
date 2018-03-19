package com.travix.medusa.busyflights.domain.toughjet;

import java.time.format.DateTimeFormatter;

public class ToughJetResponse {

	private String carrier; // Name of the Airline
	private double basePrice; // Price without tax(doesn't include discount)
	private double tax; // Tax which needs to be charged along with the price
	private double discount; // Discount which needs to be applied on the price(in percentage)
	private String departureAirportName; // 3 letter IATA code(eg. LHR, AMS)
	private String arrivalAirportName; // 3 letter IATA code(eg. LHR, AMS)
	private String outboundDateTime; // ISO_INSTANT format
	private String inboundDateTime; // ISO_INSTANT format

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(final String carrier) {
		this.carrier = carrier;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(final double basePrice) {
		this.basePrice = basePrice;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(final double tax) {
		this.tax = tax;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(final double discount) {
		this.discount = discount;
	}

	public String getDepartureAirportName() {
		return departureAirportName;
	}

	public void setDepartureAirportName(final String departureAirportName) {
		this.departureAirportName = departureAirportName;
	}

	public String getArrivalAirportName() {
		return arrivalAirportName;
	}

	public void setArrivalAirportName(final String arrivalAirportName) {
		this.arrivalAirportName = arrivalAirportName;
	}

	public String getOutboundDateTime() {
		return outboundDateTime;
	}

	public void setOutboundDateTime(final String outboundDateTime) {
		this.outboundDateTime = outboundDateTime;
	}

	public String getInboundDateTime() {
		return inboundDateTime;
	}

	public void setInboundDateTime(final String inboundDateTime) {
		this.inboundDateTime = inboundDateTime;
	}

    /**
     * Method that returns a mock containing an array of response objects
     * @param request
     * @param numOfItems
     * @return array of response objects
     */
	public static ToughJetResponse[] mockResults(ToughJetRequest request, int numOfItems) {
		ToughJetResponse[] toReturn = new ToughJetResponse[numOfItems];
		
		for(int i = 0 ; i < numOfItems ; i++) {
			ToughJetResponse tjr = new ToughJetResponse();
			tjr.setArrivalAirportName(request.getTo());
			tjr.setBasePrice(10 * (i+1));
			tjr.setCarrier("company "+ i);
			tjr.setDepartureAirportName(request.getFrom());
			tjr.setDiscount(i+1);
			tjr.setInboundDateTime(DateTimeFormatter.ISO_INSTANT.format(DateTimeFormatter.ISO_LOCAL_DATE.parse(request.getInboundDate())));
			tjr.setOutboundDateTime(DateTimeFormatter.ISO_INSTANT.format(DateTimeFormatter.ISO_LOCAL_DATE.parse(request.getOutboundDate())));
			tjr.setTax(1 + i);
			toReturn[i] = tjr;
		}

		return toReturn;
	}
}
