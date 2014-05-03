package de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe1.m1329483_m1323010.myutil;

import de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe1.m1329483_m1323010.util.IStack;

public class ArrayStack implements IStack {

	private Object[] stack;

	private int head = 0;

	private boolean overflown;

	public ArrayStack() {
		this(0);
	}

	public ArrayStack(int capacity) {
		if (capacity > 0) {
			stack = new Object[capacity];
		} else {
			stack = new Object[5];
		}
	}

	@Override
	public int capacity() {
		return stack.length;
	}

	@Override
	public void clear() {
		stack = new Object[stack.length];
	}

	private void doubleCapacity() {
		ArrayStack doubledStack = new ArrayStack(stack.length * 2);

		while (!isEmpty()) {
			doubledStack.push(pop());
		}

		stack = doubledStack.stack;
		head = doubledStack.head;
	}

	@Override
	public boolean isEmpty() {
		return peek() == null;
	}

	@Override
	public Object peek() {
		return stack[head];
	}

	@Override
	public Object pop() {
		Object obj = null;

		if (!isEmpty()) {
			obj = stack[head]; // save for return
			stack[head] = null; // delete in Stack

			// only decrease if head pointer doesn't point already
			// to the 'bottom' of the stack
			if (head > 0) {
				head--;
			}
		}

		return obj;
	}

	@Override
	public boolean push(Object obj) {
		// don't allow null to be pushed
		if (obj == null) {
			return false;
		}

		if (isEmpty()) {
			stack[head] = obj;
			return true;
		} else if (head + 1 < stack.length) { // check if there is a next empty cell
			stack[head + 1] = obj; // insert
			head++; // increase
			return true;
		} else if (!overflown) { // Stack is full and not overflown yet?
			overflown = true;
			doubleCapacity();
			push(obj); // insert yet
			return true;			
		}

		return false;
	}

	@Override
	public int size() {
		int counter = 0;

		for (Object obj : stack) {
			// abort loop if we have an empty cell which indicates
			// that every following cell is also empty
			if (obj == null) {
				break;
			}
			counter++;
		}

		return counter;
	}

	@Override
	public String toString() {
		String result = "";
		int counter = 0;

		if (!isEmpty()) {
			for (Object obj : stack) {
				if (obj != null) {
					result += counter + "[" + obj + "] ";

					if (counter == head) {
						result += "(head) ";
					}
					counter++;
				} else {
					break;
				}
			}
		} else {
			result = "Stack is empty.";
		}
		return result;
	}

}
