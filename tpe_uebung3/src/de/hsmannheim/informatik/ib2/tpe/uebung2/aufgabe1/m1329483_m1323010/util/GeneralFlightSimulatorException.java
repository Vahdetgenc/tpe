package de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe1.m1329483_m1323010.util;
//test

public class GeneralFlightSimulatorException extends Exception {

	private long reason;
	
	public GeneralFlightSimulatorException() {
		setReason(0);
	}
	
	public GeneralFlightSimulatorException(String message, int val) {
		super(message);
		setReason(val);
	}

	public long getReason() {
		return reason;
	}

	public void setReason(long reason) {
		this.reason = reason;
	}
	
	public void printinfo() {
		Print.print("Failure at " + getReason());
	}

}
