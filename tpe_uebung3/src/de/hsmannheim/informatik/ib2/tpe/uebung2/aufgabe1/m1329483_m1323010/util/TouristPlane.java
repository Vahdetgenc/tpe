package de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe1.m1329483_m1323010.util;

public class TouristPlane implements Plane {

	private int actualDistanceAboveTheCity;
	private boolean doorsAreClosed;
	private boolean moving;
	private boolean grounded;
	private int distanceTraveled;
	private FlightRoute individualRoute;

	public TouristPlane() throws GeneralFlightSimulatorException {
		try {
			this.setIndividualRoute(new FlightRoute());
			actualDistanceAboveTheCity = 0;
			doorsAreClosed = false;
			moving = false;
			grounded = true;
			distanceTraveled = 0;
		} catch (GeneralFlightSimulatorException e) {
			throw e;
		}
	}

	// individualFlightRoute als object
	public TouristPlane(int lengthOfTheRoute, int minDistACL, int maxDisACL)
			throws GeneralFlightSimulatorException {
		try {
			this.setIndividualRoute(new FlightRoute(lengthOfTheRoute,
					minDistACL, maxDisACL));
			actualDistanceAboveTheCity = 0;
			doorsAreClosed = false;
			moving = false;
			grounded = true;
			distanceTraveled = 0;
		} catch (GeneralFlightSimulatorException e) {
			throw e;
		}
	}

	public int getDistanceTraveled() {
		return distanceTraveled;
	}

	public void setDistanceTraveled(int distanceTraveled) {
		this.distanceTraveled = distanceTraveled;
	}

	@Override
	public void openDoors() throws GeneralFlightSimulatorException {
		try {
			if (isDoorsAreClosed() && !isMoving() && isGrounded()) {
				setDoorsAreClosed(false);
			} else {
				throw new GeneralFlightSimulatorException("openDoorFailure at km: ", getDistanceTraveled());
				}

		} catch (GeneralFlightSimulatorException e) {
			throw e;
		}
	}

	@Override
	public void closeDoors() {
		isDoorsAreClosed();

	}

	@Override
	public void stop() throws GeneralFlightSimulatorException {
		try {
			if (isGrounded() && isMoving()) {
				setMoving(false);
			} else {
				throw new GeneralFlightSimulatorException("stopFailure at km: ", getDistanceTraveled());
			}
		} catch (GeneralFlightSimulatorException e) {
			throw e;
		}
	}

	@Override
	public void flyNextKilometer(int additionalHeight)
			throws GeneralFlightSimulatorException {
		try {
			if (getDistanceTraveled() < 2 || getIndividualRoute().getLengthOfTheRoute()-getDistanceTraveled()<=2) {
				
			}
				
				if (checkHeighDifferenzAboveCity(additionalHeight)
						&& (getDistanceTraveled() < individualRoute
								.getLengthOfTheRoute())) {
					setDistanceTraveled(getDistanceTraveled() + 1);
					setActualDistanceAboveTheCity(getActualDistanceAboveTheCity()
							+ additionalHeight);

				} else {
				throw new GeneralFlightSimulatorException(
						"flyNextKilometerFailure at km: ",
						getDistanceTraveled());
			}

		} catch (GeneralFlightSimulatorException e) {
			throw e;
		}
	}
	
	public boolean checkNearAirport(int additionalHeight) {
		return true;
	}
	
	public boolean checkAboveCity(int additionalHeight) {
		//checkHeighDifferenzAboveCity(additionalHeight);
		return true;
	}
	
	
	

	// checks if additionalHeight for the next km is possible
	public boolean checkHeighDifferenzAboveCity(int additionalHeight) {
		if (additionalHeight > 100
				|| additionalHeight < -100
				|| (getActualDistanceAboveTheCity() + additionalHeight) < individualRoute
				.getMinDistanceAboveTheCity()
				|| (getActualDistanceAboveTheCity() + additionalHeight) > individualRoute
				.getMaxDistanceAboveTheCity()) {
			return false;
		} else {
			return true;
		}
	}

	public int getActualDistanceAboveTheCity() {
		return actualDistanceAboveTheCity;
	}

	public void setActualDistanceAboveTheCity(int actualDistanceAboveTheCity) {
		this.actualDistanceAboveTheCity = actualDistanceAboveTheCity;
	}

	public boolean isDoorsAreClosed() {
		return doorsAreClosed;
	}

	public void setDoorsAreClosed(boolean doorsAreClosed) {
		this.doorsAreClosed = doorsAreClosed;
	}

	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean isMoving) {
		this.moving = isMoving;
	}

	public boolean isGrounded() {
		return grounded;
	}

	public void setGrounded(boolean grounded) {
		this.grounded = grounded;
	}

	public FlightRoute getIndividualRoute() {
		return individualRoute;
	}

	public void setIndividualRoute(FlightRoute individualRoute) {
		this.individualRoute = individualRoute;
	}

}
