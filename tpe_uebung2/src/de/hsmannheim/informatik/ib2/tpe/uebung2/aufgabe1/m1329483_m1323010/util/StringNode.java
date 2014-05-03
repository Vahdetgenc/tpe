package de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe1.m1329483_m1323010.util;

public class StringNode extends ListNode {

	private String value;

	public StringNode(String value) {
		this.value = value;
	}

	public ListNode clone() {
		return new StringNode(this.value);
	}

	@Override
	public ListNode getNext(){
		return next;
	}

	public String getValue() {
		return value;
	}

	@Override
	boolean isEqualTo(ListNode node) {
		if (node instanceof StringNode) {
			return value.compareToIgnoreCase(((StringNode) node).getValue()) == 0;
		}
		return false;
	}

	@Override
	boolean isLessThan(ListNode node) {
		if (node instanceof StringNode) {
			return value.compareToIgnoreCase(((StringNode) node).getValue()) < 0;
		}
		return false;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
}
