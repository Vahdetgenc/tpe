/*
 * Why did we choose that package name?
 * 
 * First of all, we followed the reverse domain name conventian:
 *  -> sorting purpose
 * From an architecture side it makes sense to structure the package like we did, because it belongs
 * to:
 *  -> HS-Mannheim 
 *  -> Information technology
 *  -> IB2 course
 *  -> TPE lecture
 *  -> Task 1
 *  -> made it unique / avoid collisions with others, by appending our immatriculation number which are unique anyway
 */
package de.hsmannheim.informatik.ib2.tpe.uebung1.m1329483_m1323010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import de.hsmannheim.informatik.ib2.tpe.uebung1.m1329483_m1323010.util.IntNode;
import de.hsmannheim.informatik.ib2.tpe.uebung1.m1329483_m1323010.util.SortedList;
import de.hsmannheim.informatik.ib2.tpe.uebung1.m1329483_m1323010.util.StringNode;

public class Main {

	public static SortedList sortedInts = new SortedList();
	public static SortedList sortedInts2 = new SortedList();;
	public static SortedList sortedStrings = new SortedList();
	public static SortedList sortedStrings2 = new SortedList();

	public static void main(String[] args) {
		initializeAndStaticTest();
		ListMenu();
	}

	// Initialize Test-Lists and static test of the methods
	public static void initializeAndStaticTest() {

		print("sortedInts add : ");
		sortedInts.add(new IntNode(13));
		sortedInts.add(new IntNode(18));
		sortedInts.add(new IntNode(19));
		sortedInts.add(new IntNode(18));
		sortedInts.add(new IntNode(17));
		sortedInts.add(new IntNode(-8));
		sortedInts.add(new IntNode(3));
		sortedInts.add(new IntNode(7));
		print(sortedInts.toString());

		print("sortedInts2 add : ");
		sortedInts2.add(new IntNode(11));
		sortedInts2.add(new IntNode(13));
		sortedInts2.add(new IntNode(14));
		sortedInts2.add(new IntNode(-5));
		sortedInts2.add(new IntNode(0));
		sortedInts2.add(new IntNode(2));
		print(sortedInts2.toString());

		print("sortedInts remove -8 : ");
		sortedInts.remove(new IntNode(-8));
		print(sortedInts.toString());

		print("sortedInts cloned : ");
		print(sortedInts.clone().toString());

		print("sortedInts concat sortedInts2 : ");
		SortedList concatInts = sortedInts.concat(sortedInts2);
		print(concatInts.toString());
		System.out.println("LŠnge sortedInts : " + sortedInts.size());
		System.out.println("LŠnge sortedInts2 : " + sortedInts2.size());
		System.out.println("LŠnge concatInts : " + concatInts.size());

		print("");
		print("sortedStrings add");
		sortedStrings.add(new StringNode("ene"));
		sortedStrings.add(new StringNode("mene"));
		sortedStrings.add(new StringNode("miste"));
		sortedStrings.add(new StringNode("es"));
		sortedStrings.add(new StringNode("rappelt"));
		sortedStrings.add(new StringNode("in"));
		sortedStrings.add(new StringNode("der"));
		sortedStrings.add(new StringNode("kiste"));
		System.out.println(sortedStrings.toString());

		print("sortedStrings2 add");
		sortedStrings2.add(new StringNode("raus"));
		sortedStrings2.add(new StringNode("bist"));
		sortedStrings2.add(new StringNode("du"));
		sortedStrings2.add(new StringNode("noch"));
		sortedStrings2.add(new StringNode("lange"));
		sortedStrings2.add(new StringNode("nicht"));
		sortedStrings2.add(new StringNode("erzŠhl"));
		sortedStrings2.add(new StringNode("mir"));
		System.out.println(sortedStrings2.toString());

		print("sortedStrings remove 'ene'");
		sortedStrings.remove(new StringNode("ene"));
		System.out.println(sortedStrings.toString());

		print("sortedStrings cloned");
		print(sortedStrings.clone().toString());

		print("sortedStrings concat sortedStrings : ");
		SortedList concatStrings = sortedStrings.concat(sortedStrings2);
		print(concatStrings.toString());
		System.out.println("LŠnge sortedStrings : " + sortedStrings.size());
		System.out.println("LŠnge sortedStrings2 : " + sortedStrings2.size());
		System.out.println("LŠnge concatStrings : " + concatStrings.size());

	}

	// select a list to work with
	public static void ListMenu() {
		boolean loop = true;

		while (loop == true) {
			Main.print("Bitte die Liste wŠhlen.\n"
					+ "1) um mit der Liste sortedInts zu arbeiten.\n"
					+ "2) um mit der Liste sortedInts2 zu arbeiten.\n"
					+ "3) um mit der Liste sortedStrings zu arbeiten.\n"
					+ "4) um mit der Liste sortedStrings2 zu arbeiten.\n"
					+ "5) um eine neue (leere) Liste zu erstellen und damit zu arbeiten.\n\n"
					+ "0) zum Beenden");

			int selection = readInt();
			switch (selection) {
			case 1:
				menu(sortedInts);
				loop = false;
				break;

			case 2:
				menu(sortedInts2);
				loop = false;
				break;

			case 3:
				menu(sortedStrings);
				loop = false;
				break;

			case 4:
				menu(sortedStrings2);
				loop = false;
				break;

			case 5:
				SortedList sortedListTemp = new SortedList();

				menu(sortedListTemp);
				loop = false;
				break;

			case 0:
				print("Programm wie gewŸnscht beendet.");
				loop = false;
				break;

			default:
				print("ungŸltige Eingabe!");
			}
		}
	}

	// List-methods to select
	public static void menu(SortedList currentList) {
		boolean loop = true, TypeOfListIsInt = false;


		// checks the type of the List
		if (currentList.getFirst() instanceof IntNode) {
			TypeOfListIsInt = true;
		} else {
			TypeOfListIsInt = false;
		}
		// if list isEmtpy --> choose the type for further action
		if (currentList.isEmpty()) {
			print("Bitte wŠhlen Sie ob die Liste Int-Werte oder Strings enthalten soll.\n\n"
					+ "1) fŸr Int-Werte. \n"
					+ "2) fŸr Strings. \n");
			if (readInt() == 1){
				TypeOfListIsInt = true;
			} else {
				TypeOfListIsInt = false;
			}
		}


		while (loop == true) {
			print("Bitte die Listenmethode wŠhlen.\n" + "1) addFirst.\n"
					+ "2) addLast.\n" + "3) getFirst. \n" + "4) getN.\n"
					+ "5) getLast.\n" + "6) removeN. \n"
					+ "7) remove. (value).\n" + "8) removeLast.\n"
					+ "9) size.\n" + "10) printList.\n" + "11) isEmpty. \n"
					+ "12) clear List. \n" + "13) toArray. \n"
					+ "14) contains (value). \n" + "15) concat. \n"
					+ "99) um in die Listen-Auswahl zurŸck zu kehren.\n\n"
					+ "0) Um das Programm zu beenden.");

			int selection = readInt();

			switch (selection) {
			case 1:
				if (TypeOfListIsInt) {
					print("Bitte einen Int-Wert eingeben");
					currentList.addFirst(new IntNode(readInt()));
				} else {
					print("Bitte einen String eingeben");
					currentList.addFirst(new StringNode(readString()));
				} 

				break;

			case 2:
				if (TypeOfListIsInt) {
					print("Bitte einen Int-Wert eingeben");
					currentList.addLast(new IntNode(readInt()));
				} else {
					print("Bitte einen String eingeben");
					currentList.addLast(new StringNode(readString()));
				}
				break;

			case 3:
				print("getFirst liefert: ");
				if (TypeOfListIsInt) {
					print(((IntNode) currentList.getFirst()).toString());
				} else {
					print(((StringNode) currentList.getFirst()).toString());
				}
				break;

			case 4:
				print("Bitte Index des gewŸnschten Listenelements eingeben.");
				if (TypeOfListIsInt) {
					print(((IntNode) currentList.get(readInt())).toString());
				} else {
					print(((StringNode) currentList.get(readInt())).toString());
				}
				break;

			case 5:
				print("getLast liefert: ");
				if (TypeOfListIsInt) {
					print(((IntNode) currentList.getLast()).toString());
				} else {
					print(((StringNode) currentList.getLast()).toString());
				}
				break;

			case 6:
				print("Bitte Index zum lšschen eingeben ");
				currentList.remove(readInt());
				break;

			case 7:
				print("Bitte den zu lšschenden Int-Wert / String eingeben");
				if (TypeOfListIsInt) {
					currentList.remove(new IntNode(readInt()));
					;
				} else {
					currentList.remove(new StringNode(readString()));
					;
				}
				break;

			case 8:
				currentList.removeLast();
				break;

			case 9:
				print("Grš§e der aktuellen Liste : " + currentList.size());

				break;

			case 10:
				print(currentList.toString());
				break;

			case 11:
				if (currentList.isEmpty()) {
					print("Die aktuelle Liste ist leer.");
				} else {
					print("Die aktuelle Liste ist nicht leer.");
				}
				break;

			case 12:
				currentList.clear();
				break;

			case 13:
				currentList.toArray();

				break;

			case 14:
				print("Bitte den gewŸnschten Wert eingeben.");

				if (TypeOfListIsInt) {
					if (currentList.contains(new IntNode(readInt()))) {
						print("Wert in der Liste vorhanden.");
					} else {
						print("Wert in der Liste nicht vorhanden.");
					}
				} else {
					if (currentList.contains(new StringNode(readString()))) {
						print("String in der Liste gefunden.");
					} else {
						print("String in der Liste nicht gefunden.");
					}
				}

				break;

			case 15:
				print("Bitte die zweite Liste auswŠhlen: \n"
						+ "1) sortedInts. \n" + "2) sortedInts2.\n"
						+ "3) sortedStrings. \n" + "4) sortedStrings2.\n");
				switch (readInt()) {

				case 1:
					menu(currentList.concat(sortedInts));
					loop = false;
					break;
				case 2:
					menu(currentList.concat(sortedInts2));
					loop = false;
					break;
				case 3:
					menu(currentList.concat(sortedStrings));
					loop = false;
					break;
				case 4:
					menu(currentList.concat(sortedStrings2));
					loop = false;
					break;

				default:
					print("Fehler bei der Auswahl");
				}

				break;

			case 99:
				ListMenu();
				loop = false;
				break;

			case 0:
				loop = false;
				print("Ente gut, alles gut... ");
				break;

			default:
				print("ungŸltige Eingabe!");
			}

		}
	}

	// help-function to read a String from keyboard
	public static String readString() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		String inStr = "";
		try {
			inStr = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return inStr;
	}

	// help-function to read int from keyboard
	public static int readInt() {
		byte[] charArray = new byte[1000];
		int num = 0;
		try {
			System.in.read(charArray);
		} catch (IOException ioe) {
			System.out.println("Fehler bei der Eingabe!");
		}
		;
		for (int t = 0; charArray[t] >= '0' && charArray[t] <= '9'; t++) {
			num = (num * 10) + charArray[t] - '0';
		}
		return (num);
	}

	// Print-function
	public static void print(String x) {
		System.out.println(x);
	}
}