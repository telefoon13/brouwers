package be.vdab.services;

import be.vdab.restclients.WeerClient;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class WeerServiceImpl implements WeerService {

	private final WeerClient weerClient;

	WeerServiceImpl(WeerClient weerClient) {
		this.weerClient = weerClient;
	}

	@Override
	public BigDecimal getTemperatuur(String plaats) {
		return weerClient.getTemperatuur(plaats);
	}
}
