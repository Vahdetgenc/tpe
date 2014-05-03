package de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe1.m1329483_m1323010.util;

public interface IStack extends ICollection {

	/**
	 * Removes and returns the object at the top of the Stack.
	 * 
	 * @return
	 */
	public Object pop();

	/**
	 * Inserts an object at the top of the Stack.
	 * 
	 * @param obj
	 * @return true if object was added to the Stack, else false
	 */
	public boolean push(Object obj);
}
