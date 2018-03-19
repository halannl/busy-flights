package com.travix.medusa.busyflights.service;

import java.util.List;

import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;

public interface ProvidersClientService {
	/**
	 * Consumes Tough Jet API of flights given
	 * @param request
	 * @return List of response Objects
	 */
	List<ToughJetResponse> getToughJet(ToughJetRequest request);

	/**
	 * Consumes Crazy Air API of flights given
	 * @param request
	 * @return List of response Objects
	 */
	List<CrazyAirResponse> getCrazyAir(CrazyAirRequest request);
}
