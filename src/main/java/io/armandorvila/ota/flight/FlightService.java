package io.armandorvila.ota.flight;

import org.javamoney.moneta.Money;

public interface FlightService {

	Money calculateOperationalFlightPrice(FlightNumber flightNumber);
}
