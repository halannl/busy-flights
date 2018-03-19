package com.travix.medusa.busyflights.domain.toughjet;

public class ToughJetRequest {

    private String from; // 3 letter IATA code(eg. LHR, AMS)
    private String to; // 3 letter IATA code(eg. LHR, AMS)
    private String outboundDate; // ISO_LOCAL_DATE format
    private String inboundDate; // 	ISO_LOCAL_DATE format
    private int numberOfAdults; // Number of passengers

    public String getFrom() {
        return from;
    }

    public void setFrom(final String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(final String to) {
        this.to = to;
    }

    public String getOutboundDate() {
        return outboundDate;
    }

    public void setOutboundDate(final String outboundDate) {
        this.outboundDate = outboundDate;
    }

    public String getInboundDate() {
        return inboundDate;
    }

    public void setInboundDate(final String inboundDate) {
        this.inboundDate = inboundDate;
    }

    public int getNumberOfAdults() {
        return numberOfAdults;
    }

    public void setNumberOfAdults(final int numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }
}
