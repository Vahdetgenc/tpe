package de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe2.m1329483_m1323010.util;

public class Sort {

	// kindOfSort = true --> ShakerSort; kindOfSort = false --> InsertionSort
	public static void sortArray(boolean kindOfSort, IComparable[] ArrayToSort) {
		if (kindOfSort) {
			Print.print("Before shakerSort: ");
			Print.printArray(ArrayToSort);
			shakerSort(ArrayToSort);
			Print.print("After shakerSort: ");
			Print.printArray(ArrayToSort);
		} else {
			Print.print("Before insertionSort: ");
			Print.printArray(ArrayToSort);
			insertionSort(ArrayToSort);
			Print.print("After insertionSort: ");
			Print.printArray(ArrayToSort);
		}
	}

	// Swaps two elements with the help of swapHelper
	public static void swap(IComparable ArrayToSwap[], int bucket1, int bucket2) {
		IComparable swapHelper;
		swapHelper = ArrayToSwap[bucket1];
		ArrayToSwap[bucket1] = ArrayToSwap[bucket2];
		ArrayToSwap[bucket2] = swapHelper;
	}

	// sorts descending
	// "<" --> sorts desc; ">" --> sorts rising
	private static void insertionSort(IComparable[] ArrayToSort) {
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

	// sorts descending
	// leftToRight "<" and rightToLeft ">" -- > sorts desc
	// leftToRight ">" and rightToLeft "<" --> sorts rising
	private static void shakerSort(IComparable[] ArrayToSort) {

		boolean swapped = true;
		boolean leftToRight = true; //
		int left = 0;
		int right = ArrayToSort.length - 1;
		while (swapped) {
			swapped = false;
			// if ShakerSort has nothing to to, swapped == false --> return.

			if (leftToRight) {
				// bubble from left to right
				for (int i = left; i < right; i++) {
					if (ArrayToSort[i].compareTo(ArrayToSort[i + 1]) < 0) {
						swap(ArrayToSort, i, i + 1);
						swapped = true;
					}
				}
				right--; // decrease the sorting area on the right side
				leftToRight = false; // switch the sorting-direction for the next step

			} else {
				// bubble from right to left
				for (int j = right; j > left; j--) {
					if (ArrayToSort[j].compareTo(ArrayToSort[j - 1]) > 0) {
						swap(ArrayToSort, j, j - 1);
						swapped = true;
					}
				}
				left++; // decrease the sorting area on the left side
				leftToRight = true; // switch the sorting-direction for the next step
			}
		}
	}

}
