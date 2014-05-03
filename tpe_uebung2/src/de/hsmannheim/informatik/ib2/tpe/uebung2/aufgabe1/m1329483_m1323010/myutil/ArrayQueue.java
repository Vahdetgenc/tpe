package de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe1.m1329483_m1323010.myutil;

import de.hsmannheim.informatik.ib2.tpe.uebung2.aufgabe1.m1329483_m1323010.util.IQueue;

public class ArrayQueue implements IQueue {

	private Object[] queue;

	/*
	 * Correct position of head-/tail pointer will be determined 
	 * by the help of the modulo operation + the size of the Queue. 
	 * This is conform because therefore the head-/tail pointer only needs 
	 * to be increased after each successful enqueue/dequeue. 
	 * Example how to get the correct position of the head pointer:
	 * 
	 * 	int position = head % queue.length;
	 */
	private int head;
	private int tail;

	private boolean overflown;

	public ArrayQueue() {
		this(0);
	}

	public ArrayQueue(int capacity) {
		if (capacity > 0) {
			queue = new Object[capacity];
		} else {
			queue = new Object[5];
		}

		head = queue.length;
		tail = queue.length;
	}

	@Override
	public int capacity() {
		return queue.length;
	}

	@Override
	public void clear() {
		queue = new Object[queue.length];
	}

	@Override
	public Object dequeue() {
		Object obj = null;

		if (!isEmpty()) {
			obj = queue[(head) % queue.length]; // save object for return
			queue[(head) % queue.length] = null; // delete object in queue

			if (queue[(head + 1) % queue.length] != null) { // increase headpointer only if next element exist
				head++;
			}
		}

		return obj;
	}

	/**
	 * Copies existing queue into a new queue with a doubled capacity of current Queue.
	 */
	private void doubleCapacity() {
		ArrayQueue doubledQueue = new ArrayQueue(queue.length * 2);

		// copy current queue into new queue
		while (!isEmpty()) {
			doubledQueue.enqueue(dequeue());
		}

		// 'assign' new queue to current queue
		// this is possible because we are in the same class
		queue = doubledQueue.queue;
		head = doubledQueue.head;
		tail = doubledQueue.tail;
	}

	@Override
	public boolean enqueue(Object obj) {

		// don't allow null to be enqueued
		if (obj == null) {
			return false;
		}

		if (isEmpty()) {
			queue[tail % queue.length] = obj;
			return true;
		} else if (queue[(tail + 1) % queue.length] == null) { // next cell is empty?
			queue[(tail + 1) % queue.length] = obj; // insert in next cell
			tail++; // increase tailpointer
			return true;
		} else if (!overflown) { // Queue is full and not overflown yet?
			overflown = true;
			doubleCapacity();
			enqueue(obj); // insert again
			return true;
		}

		return false;
	}

	@Override
	public boolean isEmpty() {
		return peek() == null;
	}

	@Override
	public Object peek() {
		return queue[head % queue.length];
	}

	@Override
	public int size() {
		int counter = 0;

		for (Object obj : queue) {
			if (obj != null) {
				counter++;
			}
		}

		return counter;
	}

	@Override
	public String toString() {
		String result = "";
		int counter = 0;

		if (!isEmpty()) {
			for (Object obj : queue) {
				if (obj != null) {
					result += counter + "[" + obj + "] ";
					if (counter == (head) % queue.length) {
						result += "(head) ";
					}
					if (counter == (tail) % queue.length) {
						result += "(tail) ";
					}
				}
				counter++;
			}
		} else {
			result = "Queue is empty.";
		}
		return result;
	}
}
