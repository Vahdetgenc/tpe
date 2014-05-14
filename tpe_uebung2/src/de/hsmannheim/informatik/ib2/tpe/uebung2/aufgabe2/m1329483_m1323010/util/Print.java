package de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe2.m1329483_m1323010.util;

public class Print {

	public static void print(String x) {
		System.out.println(x);
	}

	public static void printArray(IComparable[] ArrayToPrint) {
		String output = "";

		for (int i = 0; i < ArrayToPrint.length; i++) {
			output += "  [" + i + "] " + ArrayToPrint[i].toString();
		}
		print("....................................................");
		print(output);
		print(".................................................... \n");
	}

}
