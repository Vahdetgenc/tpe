package de.hsmannheim.informatik.ib2.tpe.uebung1.m1329483_m1323010.util;

public class SortedList extends LinkedList {

	@Override
	public void add(ListNode node) {
		ListNode currentNode = root;

		if (isEmpty()) {
			super.add(node);
		} else {
			// if node is smaller than root
			if (!currentNode.isLessThan(node)) {
				node.next = currentNode;
				root = node;
			} else {
				// get the node that has a greater value than the passed node
				while (currentNode.next != null
						&& currentNode.next.isLessThan(node)) {
					currentNode = currentNode.next;
				}
				node.next = currentNode.next;
				currentNode.next = node;
			}

		}
	}

	@Override
	public void addFirst(ListNode node) {
		add(node);
	}

	@Override
	public void addLast(ListNode node) {
		ListNode beforeNode = root;
		ListNode currentNode = root;

		if (isEmpty()) {
			root = node;
		} else if (!isEmpty() && size() == 1) {
			if ((currentNode.isLessThan(node) || currentNode.isEqualTo(node))) {
				root.next = node;
			} else {
				node.next = root;
				root = node;
			}
		} else {
			while (currentNode != null
					&& (currentNode.isLessThan(node) || currentNode
							.isEqualTo(node))) {
				beforeNode = currentNode;
				currentNode = currentNode.next;
			}
			beforeNode.next = node;
			node.next = currentNode;
		}

	}

	@Override
	public SortedList clone() {
		SortedList clone = new SortedList();

		if (!isEmpty()) {
			ListNode currentNode = root;
			while (currentNode != null) {
				clone.add(currentNode.clone());
				currentNode = currentNode.next;
			}
		}
		return clone;
	}

	@Override
	public SortedList concat(LinkedList list) {
		ListNode currentNode;
		SortedList concatedList = clone();

		 // iterate through second list and append it to the current list doesn't
		 // matter if its a linked / sortedlist
		if (!list.isEmpty()) {
			currentNode = list.root;
			while (currentNode != null) {
				concatedList.add(currentNode.clone());
				currentNode = currentNode.next;
			}
		}

		return concatedList;
	}
	
	@Override
	public void insert(ListNode node, int index) {
		add(node);
	}
}
