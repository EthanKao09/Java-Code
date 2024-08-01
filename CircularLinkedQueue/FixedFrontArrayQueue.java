package Homework2;

/*
Note:   Do not add any additional methods, attributes.  
        Run your program against the provided Homework2Demo.java.
*/

/*  
Hint:   This Queue implementation will always dequeue from the first element of 
        the array i.e, elements[0].  Therefore, remember to shift all elements 
        toward front of the queue after each dequeue.
*/

public class FixedFrontArrayQueue<T> implements QueueInterface<T>{
	// Note: do not add any new attributes.
	private static int CAPACITY = 100;
	private T[] elements;
	private int rearIndex = -1;
	
	// Implement following methods:
	
	// Default constructor to initialize array capacity with CAPACITY
	public FixedFrontArrayQueue() {
		CAPACITY = 100;
		elements = (T[]) new Object[CAPACITY];
	}
	
	// Constructor to initialize array capacity with 'size'
	public FixedFrontArrayQueue(int size) {
		CAPACITY = size;
		elements = (T[]) new Object[size];
	}
	
	// Enqueue info into array. Throw QueueOverflowException if array is full
	public void enqueue(T info) {
		if(isFull()) throw new QueueOverflowException("Queue is Full");
		rearIndex++;
		elements[rearIndex] = info;
	}
	// Dequeue info from array. Throw QueueUnderflowException if array is empty
	public T dequeue() {
		if(isEmpty()) throw new QueueUnderflowException("Queue is Empty");
		T returnValue;
		if(size() == 1) {
			returnValue = elements[rearIndex];
			elements[rearIndex] = null;
		}else {
			returnValue = elements[0];
			for(int i=0; i<size()-1;i++) {
				elements[i] = elements[i+1];
			}
			elements[size()-1] = null;
		}
		rearIndex--;	
		return returnValue;
	}
	// Return true if the array is full; otherwise return false
	public boolean isFull() {
		return rearIndex + 1 == CAPACITY;
	}

	// Return true if the array is empty; otherwise return false
	public boolean isEmpty() {
		return rearIndex == -1;
	}
	// Adjust elements array capacity with 'size' more or 'size' less elements
	public int size() {
		return rearIndex+1;
	}
	// Return number of elements
	public int getQueueCapacity() {
		return CAPACITY;
	}
	//Adjust elements array capacity with 'size' more or 'size' less elements
	// .toString() method that returns a string that correctly represents the
	// current stack.
	public void resize(int size) {
		int newCapacity = getQueueCapacity() + size;
		T[] newElements = (T[]) new Object[newCapacity];
		if (size() >= 0) System.arraycopy(elements, 0, newElements, 0, size());
		CAPACITY = newCapacity;
		elements = newElements;
		
	}
	// .toString() method that returns a string that correctly represents the
	public String toString() {
		String result = "Size: " + size() + "\n";

		for (int index = 0; index < size(); index++) {
			result += elements[index] + "\n";
		}

		return result;
	}

	
	
	
	
	
	
	
	// current stack.
	// Return array capacity of the queue
	
}
