/* 		
 *		HS Mannheim - 2IB - TPE - †bung 2 - Aufgabe 2.2
 *		Members:	Josua Geiger 1323010; Sven Koehler 1329483	
 *		Prof Dr. Schramm
 */

package de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe2.m1329483_m1323010;

import de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe2.m1329483_m1323010.util.IComparable;
import de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe2.m1329483_m1323010.util.MyInt;
import de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe2.m1329483_m1323010.util.MyString;
import de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe2.m1329483_m1323010.util.Print;
import de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe2.m1329483_m1323010.util.Sort;

public class Main {
	// static testArrays to make testing simple
	public static int lengthOfTheIntArray = 5;
	public static int lengthOfTheStringArray = 5;
	public static IComparable myIntArray[];
	public static IComparable myStringArray[];

	// helper to create random words with big letters
	// gets the length of the word as int.
	public static String createRandomWord(int lengthOfTheWord) {
		String randomWord = "";
		char randomLetter;
		for (int i = 0; i < lengthOfTheWord; i++) {
			// creates random letters between 'A' - 'Z'
			// Unicode-Letter-range between 65 - 90
			randomLetter = (char) ((((int) (Math.random() * 100)) % 26) + 65);
			randomWord += randomLetter;
		}
		return randomWord;
	}

	static void initialize() {
		// initialize myIntArray with random MyInt-Objects
		myIntArray = new IComparable[lengthOfTheIntArray];
		for (int i = 0; i < lengthOfTheIntArray; i++) {
			myIntArray[i] = new MyInt((int) (Math.random() * 100));
		}

		// initialize myStringArray with random MyString-Objects
		myStringArray = new IComparable[lengthOfTheStringArray];
		for (int i = 0; i < lengthOfTheStringArray; i++) {
			String value = createRandomWord(5);
			myStringArray[i] = new MyString(value);
		}
	}

	public static void main(String[] args) {

		// initialize random and sort with shakerSort (true).
		Print.print("Initialize random and test with shakerSort: \n 1) myIntArray \n 2) myStringArray \n");
		initialize();
		Sort.sortArray(true, myIntArray);
		Sort.sortArray(true, myStringArray);

		// initialize random and sort with insertionSort (false)
		Print.print("Initialize random and test with insertionSort: \n 1) myIntArray \n 2) myStringArray \n");
		initialize();
		Sort.sortArray(false, myIntArray);
		Sort.sortArray(false, myStringArray);

	}

}
