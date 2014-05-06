package de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe2.m1329483_m1323010.util;

public class MyString implements IComparable {

	private String value;

	public MyString(String value) {
		setValue(value);
	}

	public IComparable clone() {
		return new MyString(this.value);
	}

	// this.value < value returns -1
	// this.value > value returns 1
	// this.value == value returns 0
	// ignore caseSensitivity
	@Override
	public int compareTo(Object obj) throws ClassCastException {

		try {
			if (this.getValue()
					.compareToIgnoreCase(((MyString) obj).getValue()) < 0) {
				return -1;
			} else if (this.getValue().compareToIgnoreCase(
					((MyString) obj).getValue()) == 0) {
				return 0;
			} else {
				return 1;
			}
		} catch (NullPointerException e) {
			return 1; // second obj == null, for sort null is similar to less than
		} catch (ClassCastException e) {
			Print.print("not comparable");
			throw e;
		}

	}

	public String getValue() {
		return value;
	}

	@Override
	public int hashCode() {
		int hash = 1;
		hash = hash * 17 + getValue().hashCode();
		return hash;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "" + getValue();
	}
}
