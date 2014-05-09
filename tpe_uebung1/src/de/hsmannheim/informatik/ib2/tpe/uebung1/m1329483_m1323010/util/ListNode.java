package de.hsmannheim.informatik.ib2.tpe.uebung1.m1329483_m1323010.util;

abstract class ListNode {
	
	ListNode next;

	abstract public ListNode clone();

	abstract boolean isEqualTo(ListNode n);

	abstract boolean isLessThan(ListNode n);
}
