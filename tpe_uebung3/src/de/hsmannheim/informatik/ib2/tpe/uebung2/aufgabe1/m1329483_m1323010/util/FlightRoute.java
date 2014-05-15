package de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe1.m1329483_m1323010.util;

public class FlightRoute {

	// lengthOfTheRoute in km
	// min = 1 km; max = 100 km.
	private int lengthOfTheRoute;

	// minDistanceAboveTheCity in m
	// min = 1 m; max = 9999 m.
	private int minDistanceAboveTheCity;

	// maxDistanceAboveTheCity in m
	// min = 2 m; max = 10000 m; bigger than minDistanceAboveTheCity
	private int maxDistanceAboveTheCity;

	// If nothing is chosen, set to standard values
	public FlightRoute() throws GeneralFlightSimulatorException {
		try {
			setLengthOfTheRoute(50);
			setMinDistanceAboveTheCity(50);
			setMaxDistanceAboveTheCity(10000);
		} catch (GeneralFlightSimulatorException e) {
			throw e;
		}

	}

	public FlightRoute(int lengthOfTheRoute, int minDistanceAboveTheCity,
			int maxDistanceAboveTheCity) throws GeneralFlightSimulatorException {
		try {
			setLengthOfTheRoute(lengthOfTheRoute);
			setMinDistanceAboveTheCity(minDistanceAboveTheCity);
			setMaxDistanceAboveTheCity(maxDistanceAboveTheCity);
		} catch (GeneralFlightSimulatorException e) {
			throw e;
		}
	}

	public int getLengthOfTheRoute() {
		return lengthOfTheRoute;
	}

	public void setLengthOfTheRoute(int lengthOfTheRoute)
			throws GeneralFlightSimulatorException {
		if (lengthOfTheRoute <= 0) {
			throw new GeneralFlightSimulatorException(
					"lengthOfTheRoute <= 0 km", -1);
		} else if (lengthOfTheRoute > 100) {
			throw new GeneralFlightSimulatorException(
					"lengthOfTheRoute > 100 km", -1);
		} else {
			this.lengthOfTheRoute = lengthOfTheRoute;
		}
	}

	public int getMaxDistanceAboveTheCity() {
		return maxDistanceAboveTheCity;
	}

	public void setMaxDistanceAboveTheCity(int maxDistanceAboveTheCity)
			throws GeneralFlightSimulatorException {
		if (maxDistanceAboveTheCity <= 1) {
			throw new GeneralFlightSimulatorException(
					"maxDistanceAboveTheCity <= 0 m", -1);
		} else if (maxDistanceAboveTheCity > 10000) {
			throw new GeneralFlightSimulatorException(
					"maxDistanceAboveTheCity > 10000 m", -1);
		} else if (maxDistanceAboveTheCity < this.getMinDistanceAboveTheCity()) {
			throw new GeneralFlightSimulatorException(
					"maxDistanceAboveTheCity < MinDistanceAboveTheCity", 2);

		}
		this.maxDistanceAboveTheCity = maxDistanceAboveTheCity;
	}

	public int getMinDistanceAboveTheCity() {
		return minDistanceAboveTheCity;
	}

	public void setMinDistanceAboveTheCity(int minDistanceAboveTheCity)
			throws GeneralFlightSimulatorException {
		if (minDistanceAboveTheCity <= 0) {
			throw new GeneralFlightSimulatorException(
					"minDistanceAboveTheCity <= 0 m", -1);
		} else if (minDistanceAboveTheCity > 9999) {
			throw new GeneralFlightSimulatorException(
					"minDistanceAboveTheCity > 9999 m", -1);
		} else {
			this.minDistanceAboveTheCity = minDistanceAboveTheCity;
		}
	}

}
