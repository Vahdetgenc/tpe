package de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe2.m1329483_m1323010.util;

public class InsertionSort implements ISortMethod {
	
	
	// sorts descending
	// "<" --> sorts desc; ">" --> sorts rising
	@Override
	public void sort(IComparable[] ArrayToSort) {
		for (int i = 1; i < ArrayToSort.length; i++) {
			int j = i;
			IComparable tempBucket = ArrayToSort[i]; // remember bucket

			while (j > 0 && ArrayToSort[j - 1].compareTo(tempBucket) < 0) {
				// move all bigger elements to the back
				ArrayToSort[j] = ArrayToSort[j - 1];
				j--;
			}
			ArrayToSort[j] = tempBucket; // set tempBucket to the free bucket
		}
	}
	
	

}
