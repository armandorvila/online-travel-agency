package io.armandorvila.ota.flight;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * <b>Value object</b> that models an OTA Flight Number.
 */
@ToString
@AllArgsConstructor
public final class FlightNumber {

	private static final String FLIGHT_NUMBER_FORMAT = "%s %s %s";

	@Getter
	@Length(min = 4, max = 4)
	private String airlineNameCode;

	@Getter
	@Length(min = 4, max = 4)
	private String operationalBaseId;

	@Getter
	@Length(min = 5, max = 5)
	private String flightOperationalId;

	public String toFlightNumber() {
		return String.format(FLIGHT_NUMBER_FORMAT, airlineNameCode, operationalBaseId, flightOperationalId);
	}
}
