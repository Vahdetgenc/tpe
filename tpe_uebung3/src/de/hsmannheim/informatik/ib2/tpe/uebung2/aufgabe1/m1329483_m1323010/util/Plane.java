package de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe1.m1329483_m1323010.util;

public interface Plane {
	/**
	* Öffnet die Türen des Flugzeugs. Damit die Türen geöffnet werden können, * muss sich das Flugzeug auf dem Boden befinden und darf sich nicht
	* mehr bewegen.
	* @throws GeneralFlightSimulatorException
	* Wenn das Flugzeug noch in der Luft ist oder noch nicht
	* still steht.
	*/
	public void openDoors() throws GeneralFlightSimulatorException;
	
	/**
	* Schließt die Türen des Flugzeugs. */
	public void closeDoors();
	/**
	* Hält das Flugzeug an, wenn es gerade auf dem Boden fährt. * @throws GeneralFlightSimulatorException
	* Wenn das Flugzeug in der Luft ist
	*/
	public void stop() throws GeneralFlightSimulatorException;
	/**
	* Lässt das Flugzeug einen weiteren Kilometer fliegen, der Höhenunterschied * wird als Parameter angegeben.
	* @param additionalHeight
	* Der Höhenunterschied, den das Flugzeug in diesem Kilometer höher / * niedriger fliegt als zuvor. Kann positiv oder negativ sein.
	* @throws GeneralFlightSimulatorException
	* Falls beim Fliegen Probleme auftauchen.
	*/
	public void flyNextKilometer(int additionalHeight) throws
	GeneralFlightSimulatorException;
}
