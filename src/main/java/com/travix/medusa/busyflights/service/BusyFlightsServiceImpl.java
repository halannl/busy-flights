package com.travix.medusa.busyflights.service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;

@Service
public class BusyFlightsServiceImpl implements BusyFlightsService {

	@Autowired
	private ProvidersClientService providersClientService;

	@Override
	public List<BusyFlightsResponse> getFlights(BusyFlightsRequest request) {
		
		List<BusyFlightsResponse> toReturn = new ArrayList<BusyFlightsResponse>();
		toReturn.addAll(consumeCrazyAir(request));
		toReturn.addAll(consumeToughJet(request));
		Collections.sort(toReturn);
		return toReturn;
	}

	/**
	 * Starts the process of consuming tough jet API to generate busy flights data
	 * @param request BusyFlightsRequest
	 * @return List of BusyFlightsResponse
	 */
	private List<BusyFlightsResponse> consumeToughJet(BusyFlightsRequest request) {
		ToughJetRequest tjr = new ToughJetRequest();
		tjr.setFrom(request.getOrigin());
		tjr.setInboundDate(request.getDepartureDate());
		tjr.setNumberOfAdults(request.getNumberOfPassengers());
		tjr.setOutboundDate(request.getReturnDate());
		tjr.setTo(request.getDestination());

		return provideBusyFlightsFromToughJet(providersClientService.getToughJet(tjr));
	}

	/**
	 * Generates busy flights data from the response of tough jet API
	 * @param toughJet response list
	 * @return List of BusyFlightsResponse
	 */
	private List<BusyFlightsResponse> provideBusyFlightsFromToughJet(List<ToughJetResponse> toughJet) {
		List<BusyFlightsResponse> toReturn = new ArrayList<BusyFlightsResponse>();
		for (ToughJetResponse tjr : toughJet) {
			BusyFlightsResponse bfr = new BusyFlightsResponse();
			bfr.setAirline(tjr.getCarrier());
			bfr.setArrivalDate(DateTimeFormatter.ISO_DATE_TIME
					.format(DateTimeFormatter.ISO_INSTANT.parse(tjr.getOutboundDateTime())));
			bfr.setDepartureAirportCode(tjr.getDepartureAirportName());
			bfr.setDepartureDate(DateTimeFormatter.ISO_DATE_TIME
					.format(DateTimeFormatter.ISO_INSTANT.parse(tjr.getInboundDateTime())));
			bfr.setDestinationAirportCode(tjr.getArrivalAirportName());
			bfr.setFare((tjr.getBasePrice() * tjr.getDiscount() / 100) + tjr.getTax());
			bfr.setSupplier("ToughJet");
		}
		return toReturn;
	}

	/**
	 * Starts the process of consuming crazy air API to generate busy flights data
	 * @param request BusyFlightsRequest
	 * @return List of BusyFlightsResponse
	 */
	private List<BusyFlightsResponse> consumeCrazyAir(BusyFlightsRequest request) {
		CrazyAirRequest car = new CrazyAirRequest();
		car.setDepartureDate(request.getDepartureDate());
		car.setDestination(request.getDestination());
		car.setOrigin(request.getOrigin());
		car.setPassengerCount(request.getNumberOfPassengers());
		car.setReturnDate(request.getReturnDate());

		return provideBusyFlightsFromCrazyAir(providersClientService.getCrazyAir(car));
	}

	/**
	 * Generates busy flights data from the response of crazy air API
	 * @param crazyAir response list
	 * @return List of BusyFlightsResponse
	 */
	private List<BusyFlightsResponse> provideBusyFlightsFromCrazyAir(List<CrazyAirResponse> crazyAir) {
		List<BusyFlightsResponse> toReturn = new ArrayList<BusyFlightsResponse>();
		for (CrazyAirResponse car : crazyAir) {
			BusyFlightsResponse bfr = new BusyFlightsResponse();
			bfr.setAirline(car.getAirline());
			bfr.setArrivalDate(DateTimeFormatter.ISO_DATE_TIME
					.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME.parse(car.getArrivalDate())));
			bfr.setDepartureAirportCode(car.getDepartureAirportCode());
			bfr.setDepartureDate(DateTimeFormatter.ISO_DATE_TIME
					.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME.parse(car.getDepartureDate())));
			bfr.setDestinationAirportCode(car.getDestinationAirportCode());
			bfr.setFare(car.getPrice());
			bfr.setSupplier("CrazyAir");
		}
		return toReturn;
	}

}
