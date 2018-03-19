package com.travix.medusa.busyflights.service;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;

@Service
public class ProvidersClientServiceImpl implements ProvidersClientService {

	@Value("{crazyair.http.get.url}")
	private String crazyairUrl;

	@Value("{toughjet.http.get.url}")
	private String toughjetUrl;

	/**
	 * Consumes tough jet API (return a mock if the request fails, in case of the API don't exist)
	 * 
	 * @param request ToughJetRequest
	 * @return List of ToughJetResponse
	 */
	public List<ToughJetResponse> getToughJet(ToughJetRequest request) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<ToughJetResponse[]> response = restTemplate.getForEntity(toughjetUrl, ToughJetResponse[].class,
				asParamsMap(request));
		if (response.getStatusCode() != HttpStatus.OK) {
			return Arrays.asList(ToughJetResponse.mockResults(request, 5));
		}
		return Arrays.asList(response.getBody());
	}

	/**
	 * Consumes crazy air API (return a mock if the request fails, in case of the API don't exist)
	 * 
	 * @param request CrazyAirRequest
	 * @return List of CrazyAirResponse
	 */
	public List<CrazyAirResponse> getCrazyAir(CrazyAirRequest request) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<CrazyAirResponse[]> response = restTemplate.getForEntity(crazyairUrl, CrazyAirResponse[].class,
				asParamsMap(request));
		if (response.getStatusCode() != HttpStatus.OK) {
			return Arrays.asList(CrazyAirResponse.mockResults(request, 5));
		}

		return Arrays.asList(response.getBody());
	}

	/**
	 * Iterate over Object's fields using reflection to generate a map of params based in each field of the obj
	 * @param obj
	 * @return Map of field names and values
	 */
	private Map<String, String> asParamsMap(Object obj) {
		Map<String, String> toReturn = new HashMap<String, String>();

		for (Field field : obj.getClass().getDeclaredFields()) {
			try {
				if (field.get(obj) != null) {
					toReturn.put(field.getName(), String.valueOf(field.get(obj)));
				}
			} catch (IllegalArgumentException | IllegalAccessException e) {
				System.out.println("Error getting value of " + field.getName());
				e.printStackTrace();
			}
		}

		return toReturn;
	}
}
