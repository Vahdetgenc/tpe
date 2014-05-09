package de.hsmannheim.informatik.ib2.tpe.uebung1.m1329483_m1323010.util;

public class LinkedList {

	protected ListNode root = null;

	public void add(ListNode node) {
		ListNode temp = root;
		if (isEmpty()) {
			root = node;
		} else {
			// iterate through list elements to the last element
			while (temp.next != null) {
				temp = temp.next;
			}
			// append element to the last element
			temp.next = node;
		}
	}

	public void addFirst(ListNode node) {
		node.next = root;
		root = node;
	}

	public void addLast(ListNode node) {
		add(node);
	}

	public void append(LinkedList list) {
		getLast().next = list.getFirst();
	}

	public void clear() {
		root = null;
	}

	public LinkedList clone() {
		LinkedList clone = new LinkedList();

		if (!isEmpty()) {
			ListNode currentNode = root;
			while (currentNode != null) {
				clone.add(currentNode.clone());
				currentNode = currentNode.next;
			}
		}
		return clone;
	}

	public LinkedList concat(LinkedList list) {
		ListNode currentNode;
		LinkedList concatedList = clone();
		
		//iterate through second list and append it to the current list
		if(!list.isEmpty()){
			currentNode = list.root;
			while(currentNode != null){
				concatedList.add(currentNode.clone());
				currentNode = currentNode.next;
			}
		}
		
		return concatedList;
	}

	public boolean contains(ListNode node) {
		ListNode currentNode = root;

		while (currentNode != null) {
			if (currentNode.isEqualTo(node)) {
				return true;
			}
			currentNode = currentNode.next;
		}
		return false;
	}

	public ListNode get(int index) {

		// returns object at index, if index is ok null otherwise

		if (index > 0 && index <= size()) {
			ListNode node = root;
			for (int i = 1; i < index; i++) {
				node = node.next;
			}
			return node;
		} else {
			return null;
		}
	}

	public ListNode getFirst() {
		return root;
	}

	public ListNode getLast() {
		ListNode currentNode = root;

		if (!isEmpty() && currentNode.next != null) { // more than 1
			while (currentNode != null) {
				currentNode = currentNode.next;
			}
		}
		return currentNode;
	}

	public void insert(ListNode node, int index) {
		ListNode currentNode = root;
		ListNode beforeNode = root;

		int currentIndex = 0;

		if (!isEmpty() && index >= 0 && index <= size()) {
			// iterate to index
			while (currentNode != null && currentIndex != index) {
				beforeNode = currentNode;
				currentNode = currentNode.next;
				currentIndex++;
			}

			// insert
			if (index == 0) {
				root = node;
				node.next = currentNode;
			} else {
				beforeNode.next = node;
				node.next = currentNode;
			}
		}
	}

	public boolean isEmpty() {
		return root == null;
	}

	public boolean remove(int index) {
		// delete element at index
		// return true if index is ok, false otherwise

		if (index >= 0 && index < size()) {
			ListNode currentNode = root;
			for (int i = 0; i < index; i++) {
				currentNode = currentNode.next;
			}

			if (index == 0) {
				root = currentNode.next;
			} else {
				currentNode.next = currentNode.next.next;
			}
			return true;
		} else {
			return false;
		}
	}

	public void remove(ListNode node) {
		ListNode beforeNode = root;
		ListNode currentNode = root;

		if (!isEmpty()) {
			if (currentNode.isEqualTo(node)) {
				removeFirst();
			} else {
				while (currentNode != null) {
					if (currentNode.isEqualTo(node)) {
						// remove
						beforeNode.next = currentNode.next;
						return;
					}
					beforeNode = currentNode;
					currentNode = currentNode.next;
				}
				// if node not found --> do nothing
			}
		}
	}

	public void removeFirst() {
		// list contains more than two elements
		if (!isEmpty() && root.next != null) {
			root = root.next;
			// if the list contains less than two elements
		} else {
			clear();
		}
	}

	public void removeLast() {
		ListNode temp = root;

		if (isEmpty() || root.next != null) {
			clear();
		} else {
			// iterate through list till nex element has no follower
			while (temp.next != null && temp.next.next != null) {
				temp = temp.next;
			}
			// delete next element that has no follower
			temp.next = null;
		}
	}

	public int size() {
		ListNode currentNode = root;
		int counter = 0;

		while (currentNode != null) {
			counter++;
			currentNode = currentNode.next;
		}

		return counter;
	}

	public ListNode[] toArray() {
		ListNode currentNode = root;
		ListNode[] arrayList = new ListNode[size()];
		int index = 0;

		while (currentNode != null) {
			arrayList[index] = currentNode.clone();
			currentNode = currentNode.next;
		}

		return arrayList;
	}

	@Override
	public String toString() {
		ListNode currentNode = root;
		String result = "";
		int counter = 1;

		while (currentNode != null) {
			result += counter + "[" + currentNode.toString() + "]  ";
			currentNode = currentNode.next;
			counter++;
		}

		return result;
	}
}