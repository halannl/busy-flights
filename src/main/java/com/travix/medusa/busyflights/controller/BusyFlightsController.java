package com.travix.medusa.busyflights.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.service.BusyFlightsService;

@RestController
public class BusyFlightsController {

	@Autowired
	private BusyFlightsService busyFlightsService;

	@RequestMapping(value = "/getFlights", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<BusyFlightsResponse> getFlights(@RequestParam("origin") String origin,
			@RequestParam("destination") String destination, @RequestParam("departureDate") String departureDate,
			@RequestParam("returnDate") String returnDate, @RequestParam("numberOfPassengers") int numberOfPassengers) {
		
		//TODO validate the request parameters
		
		return busyFlightsService
				.getFlights(buildRequest(origin, destination, departureDate, returnDate, numberOfPassengers));
	}

	private BusyFlightsRequest buildRequest(String origin, String destination, String departureDate, String returnDate,
			int numberOfPassengers) {
		BusyFlightsRequest toReturn = new BusyFlightsRequest();
		toReturn.setDepartureDate(departureDate);
		toReturn.setDestination(destination);
		toReturn.setNumberOfPassengers(numberOfPassengers);
		toReturn.setOrigin(origin);
		toReturn.setReturnDate(returnDate);

		return toReturn;
	}
}
