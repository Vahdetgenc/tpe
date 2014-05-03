package de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe1.m1329483_m1323010.util;

public interface ICollection {
	
	/**
	 * Returns the number of elements the Collection is able to store.
	 * 
	 * @return
	 */
	public int capacity();
	
	/**
	 * Removes all objects from the Collection.
	 */
	public void clear();

	/**
	 * Returns information if Collection stores elements or not.
	 * 
	 * @return true if empty, else false
	 */
	public boolean isEmpty();

	/**
	 * Returns first object of the Collection without removing it.
	 * 
	 * @return
	 */
	public Object peek();

	/**
	 * Returns number of elements the Collection contains.
	 * 
	 * @return
	 */
	public int size();

}
