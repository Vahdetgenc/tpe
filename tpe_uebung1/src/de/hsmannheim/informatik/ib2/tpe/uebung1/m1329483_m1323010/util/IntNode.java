package de.hsmannheim.informatik.ib2.tpe.uebung1.m1329483_m1323010.util;

public class IntNode extends ListNode {

	private int value;

	public IntNode(int value) {
		this.value = value;
	}

	public ListNode clone() {
		return new IntNode(this.value);
	}

	public int getValue() {
		return value;
	}

	@Override
	boolean isEqualTo(ListNode node) {
		if (node instanceof IntNode) {
			return ((IntNode) node).getValue() == this.value;
		}
		return false;
	}

	@Override
	boolean isLessThan(ListNode node) {
		if (node instanceof IntNode) {
			return this.value < ((IntNode) node).getValue();
		}
		return false;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "" + value;
	}
}
